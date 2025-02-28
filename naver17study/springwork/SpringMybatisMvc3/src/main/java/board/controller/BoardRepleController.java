package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardRepleDto;
import data.mapper.BoardRepleMapper;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardRepleController {
	
	final MemberService memberService;
	final BoardRepleMapper repleService;
	final NcpObjectStorageService storageService;
	
	//버켓 이름
	private String bucketName="bitcamp-bucket-107";//각자 자기꺼 써야함
	
	private String uploadFilename;//댓글에서 업로드한 파일명
	
	@PostMapping("/repleupload")
	public String upload(@RequestParam("upload") MultipartFile upload)
	{
		//사진을 다시 올릴 경우 이전 사진은 삭제
		if(uploadFilename!=null)
			storageService.deleteFile(uploadFilename, "board", uploadFilename);
		
		uploadFilename=storageService.uploadFile(bucketName, "board", upload);
		return uploadFilename;
	}
	
	@GetMapping("/replephotodel")
	public void photoDel(@RequestParam String fname)
	{
		storageService.deleteFile(uploadFilename, "board", fname);
		uploadFilename=null;
	}
	
	@GetMapping("/addreple")
	public void addReple(@RequestParam int idx, @RequestParam String message,HttpSession session) 
	{
		//로그인한 아이디
		String loginid=(String)session.getAttribute("loginid");
		
		//클래스명 .bulider()로 시작하여 값을 세팅 후 build()호출하여 객체 생성
		BoardRepleDto dto=BoardRepleDto.builder()
				.idx(idx)
				.message(message)
				.myid(loginid)
				.photo(uploadFilename)
				.build();
		
		repleService.insertReple(dto);
		uploadFilename=null;
	}
	
	@GetMapping("/replelist")
	public List<BoardRepleDto> replelist(@RequestParam int idx)
	{
		List<BoardRepleDto> list=null;
		list=repleService.getRepleByIdx(idx);
		
		for(int i=0;i<list.size();i++)
		{
			String writer=memberService.getSelectByMyid(list.get(i).getMyid()).getMname();
			String profilePhoto=memberService.getSelectByMyid(list.get(i).getMyid()).getMphoto();
			list.get(i).setWriter(writer);//댓글 작성자 저장
			list.get(i).setProfilePhoto(profilePhoto);//댓글 작성자 프로필사진 저장
		}
		return list;
	}
	
	@GetMapping("/repledel")
	public void repleDelete(@RequestParam int num)
	{
		System.out.println("num="+num);
		//네이버 스토리지의 사진 삭제
		//삭제할 파일명
		String photo=repleService.getPhoto(num);
		storageService.deleteFile(bucketName, "board", photo);
		
		//db삭제
		repleService.deleteBoardReple(num);
	}
	
	@PostMapping("/updatereple")
	@ResponseBody
	public String updateReple(@RequestParam("num") int num,@RequestParam("message") String message)
	{
		//List<BoardRepleDto> list=null;
		BoardRepleDto dto=new BoardRepleDto();
		
		dto=repleService.getRepleByNum(num);
		if (dto == null) {
	        return "fail";
	    }
		
		dto.setMessage(message);
		
		repleService.updateReple(dto);
		return "dto";
	}
	
	
}
