package board.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.ec2.model.Storage;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.dto.BoardRepleDto;
import data.dto.MemberDto;
import data.service.BoardFileService;
import data.service.BoardRepleService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	final BoardService boardService;
	final BoardFileService fileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	final BoardRepleService repleService;
	
	//버켓 이름
	private String bucketName="bitcamp-bucket-107";//각자 자기꺼 써야함
	
	@GetMapping("/writeform")
	public String writeForm(
			//아래 4개의 값은 답글일때만 넘어온다, 새글일 때는 null값이 넘어오므로
			//required를 false로 주거나 defaultValue를 지정해야함
			@RequestParam(value="idx", defaultValue="0") int idx,
			@RequestParam(value="regroup", defaultValue="0") int regroup,
			@RequestParam(value="restep", defaultValue="0") int restep,
			@RequestParam(value="relevel", defaultValue="0") int relevel,
			@RequestParam(value="pageNum",defaultValue="1") int pageNum,
			Model model
			)
	{
		model.addAttribute("idx",idx);
		model.addAttribute("regroup",regroup);
		model.addAttribute("restep",restep);
		model.addAttribute("relevel",relevel);
		model.addAttribute("pageNum",pageNum);
		
		return "board/writeform";
	}
	
	@PostMapping("/insert")
	public String insert(
			@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload,
			HttpSession session
			)
	{
		
		//세션으로부터 아이디를 얻는다
		String myid = (String) session.getAttribute("loginid");//형변환은 myid가 null이어도 에러안남
		
		//아이디를 이용해서 멤버 테이블에서 작성자를 얻는다(아이디와 작성자는 dto에 넣어야함)
		String writer=memberService.getSelectByMyid(myid).getMname();
		
		
		dto.setMyid(myid);
		dto.setWriter(writer);
		
		//게시판 내용을 일단 db에 저장(그래야만 dto가 idx를 얻어올 수 있음)
		boardService.insertBoard(dto);
	    
		//파일이 있는 경우에만 해당, 네이버스토리지에 저장 후 파일 저장(이때 필요한게 idx,filename)
		//반복문 안에서 이루어져야만 한다
		BoardFileDto filedto=new BoardFileDto();
		if(!upload.get(0).getOriginalFilename().equals(""))
		{
			for(MultipartFile file:upload) 		
			{
				String filename=storageService.uploadFile(bucketName, "board", file);
				//boardfile에 insert
				filedto.setIdx(dto.getIdx());
				filedto.setFilename(filename);
				
				fileService.insertBoardFile(filedto);
			}
		}
		
		return "redirect:./list?pageNum="+pageNum;
	}
    
	@GetMapping("/detail")
	public String detail(@RequestParam int idx,
			@RequestParam(defaultValue="1") int pageNum,
			Model model,
			HttpSession session
			)
	{
		//조회수 증가
		boardService.updateReadCount(idx);
		
		//idx에 해당하는 dto얻기
		BoardDto dto=boardService.getSelectByIdx(idx);
		
		//리플 정보 얻기
		BoardRepleDto rdto=new BoardRepleDto();
		
		
		//idx 글에 등록된 파일들 가져오기
		List<String> fileList=new Vector<>();
		List<BoardFileDto> flist=fileService.getFiles(idx);
		for(BoardFileDto fdto:flist)
		{
			fileList.add(fdto.getFilename());
		}
		
		dto.setPhotos(fileList);
		
		//해당 아이디에대한 사진을 멤버 테이블에서 얻기
		String memberPhoto=memberService.getSelectByMyid(dto.getMyid()).getMphoto();
		//로그인한 아이디에 해당하는 이름
		String loginid=(String)session.getAttribute("loginid");
		String writer=memberService.getSelectByMyid(loginid).getMname();
		
		//리플에 해당하는 message 저장
		//String message=repleService.getRepleByIdx(idx);
		
		//모델에 저장
		model.addAttribute("writer",writer);
		model.addAttribute("dto", dto);
		model.addAttribute("memberPhoto",memberPhoto);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/"+bucketName);
		
		return "board/boarddetail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(
			@RequestParam int idx,
			@RequestParam int pageNum,
			Model model
			)
	{
		BoardDto dto=boardService.getSelectByIdx(idx);
		//model.addAttribute("writer",writer);
		model.addAttribute("dto",dto);
		model.addAttribute("pageNum",pageNum);
		model.addAttribute("naverurl","https://kr.object.ncloudstorage.com/"+bucketName);
		
		return "board/updateform";//포워드
	}
	
	//수정 폼에서 기존 사진 목록 나타냄
	@GetMapping("/photolist")
	@ResponseBody
	public List<BoardFileDto> photoList(@RequestParam int idx)
	{
		List<BoardFileDto> list=fileService.getFiles(idx);
		return list;
	}
	
	//수정 폼에서 각각의 사진 삭제 시
	@GetMapping("/photodel")
	@ResponseBody
	public void deletePhoto(@RequestParam int num)
	{
		//스토리지에 있는 파일명 얻기
		String filename=fileService.getFilename(num);
		
		//스토리지에서 사진 삭제
		storageService.deleteFile(bucketName, "board", filename);
		
		//사진 삭제
		fileService.deleteFile(num);
	}
	
	//사진 추가 및 글 수정
	@PostMapping("/update")
	public String update(
			@ModelAttribute BoardDto dto,
			@RequestParam int pageNum,
			@RequestParam("upload") List<MultipartFile> upload
			)
	{
		//제목 및 내용 수정
		boardService.updateBoard(dto);
		//사진은 추가
		//파일이 있는 경우에만 해당, 네이버스토리지에 저장 후 파일 저장(이때 필요한게 idx,filename)
		//반복문 안에서 이루어져야만 한다
		BoardFileDto filedto=new BoardFileDto();
		if(!upload.get(0).getOriginalFilename().equals(""))
		{
			for(MultipartFile file:upload) 		
			{
				String filename=storageService.uploadFile(bucketName, "board", file);
				BoardFileDto bdto=new BoardFileDto();
				bdto.setIdx(dto.getIdx());
				bdto.setFilename(filename);
				//boardfile에 insert
				fileService.insertBoardFile(bdto);
			}
		}
		return "redirect:./detail?idx="+dto.getIdx()+"&pageNum="+pageNum;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public void boardDelete(@RequestParam int idx
			
			)
	{
		//idx에 해당하는 파일들 삭제
		List<BoardFileDto> filelist=fileService.getFiles(idx);
		for(BoardFileDto fdto:filelist)
		{
			String filename=fdto.getFilename();
			storageService.deleteFile(bucketName, "board", filename);
		}
		
		boardService.deleteBoard(idx);//원글을 지우면 그 글에 업로드된 파일들 db정보는 자동으로 지워짐
	}
	
	
}
