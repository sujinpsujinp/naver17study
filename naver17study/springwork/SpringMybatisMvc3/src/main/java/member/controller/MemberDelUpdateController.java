package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
//@AllArgsConstructor
//final 을 붙인 멤버변수만 자동주입
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberDelUpdateController {
	
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	NcpObjectStorageService storageService;
		
	//버켓 이름
	private String bucketName="bitcamp-bucket-107";//각자 자기꺼 써야함
	
	
	@GetMapping("/delete")
	public String deleteMember(@RequestParam int num) 
	{
		
		memberService.deleteMember(num);
		
		return "redirect:./list";
	}
	
	@GetMapping("/mypagedel")
	@ResponseBody
	public void mypageDelete(@RequestParam int num,HttpSession session) 
	{
		
		memberService.deleteMember(num);
		
		//모든 세션 제거
		session.removeAttribute("loginstatus");
		session.removeAttribute("loginid");
		session.removeAttribute("loginphoto");
	}
	
	@GetMapping("/checkdel")
	@ResponseBody //ajax로 호출할 것
	public void checkDeleteMember(@RequestParam String nums) 
	{
		//삭제할 num들
		String []num=nums.split(",");
		for(String str:num )
		{
			int n=Integer.parseInt(str);
			memberService.deleteMember(n);
		}
	}
	
	@GetMapping("/mypage")
	public String goMypage(HttpSession session,Model model)
	{
		//세션으로부터 아이디를 얻는다
		String myid=(String)session.getAttribute("loginid");
		//아이디에 해당하는 dto 얻기
		MemberDto dto=memberService.getSelectByMyid(myid);
		//모델에 dto저장
		model.addAttribute("dto", dto);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-107");//수정하자
		return "member/mypage";
	}
	
	@PostMapping("/changephoto")
	@ResponseBody
	public void changePhoto(
			HttpServletRequest request,
			@RequestParam("upload") MultipartFile upload,
			@RequestParam("num") int num,
			HttpSession session
			)
	{
		//		//save 경로
		//		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		//		//기존 파일명 얻기
		//		String oldFilename=memberService.getSelectByNum(num).getMphoto();
		//		//기존 파일 삭제
		//		File oldFile=new File(uploadFolder+"/"+oldFilename);
		//		if(oldFile.exists())
		//			oldFile.delete();
		//		//upload 할 파일명
		//		String uploadFilename=UUID.randomUUID()+"."+upload.getOriginalFilename().split("\\.")[1];
		//		//업로드
		//		try {
		//			upload.transferTo(new File(uploadFolder+"/"+uploadFilename));
		//			//session 도 변경
		//			session.setAttribute("loginphoto", uploadFilename);
		//			
		//			//db 도 사진변경
		//			memberService.changePhoto(uploadFilename, num);
		//		} catch (IllegalStateException | IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}


		//사진수정시 db 에 저장된 파일명을 받아서 스토리지에서 삭제후 추가할것
		String oldFilename=memberService.getSelectByNum(num).getMphoto();
		storageService.deleteFile(bucketName, "member", oldFilename);

		//네이버 스토리지에 업로드
		String uploadFilename=storageService.uploadFile(bucketName, "member", upload);
		//db 에서도 수정
		memberService.changePhoto(uploadFilename, num);
		//세션도 변경
		session.setAttribute("loginphoto", uploadFilename);

	}

	@GetMapping("/updatemember")
	@ResponseBody
	public void updateMember(
			@RequestParam String mname,
			@RequestParam String mhp,
			@RequestParam String maddr,
			@RequestParam int num
			) 
	{
		MemberDto dto=new MemberDto();
		dto.setMname(mname);
		dto.setMaddr(maddr);
		dto.setMhp(mhp);
		dto.setNum(num);
		memberService.updateMember(dto);
	}
	
}
