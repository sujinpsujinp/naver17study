package controller.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FileNameChange;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UploadMunjaeController {
	
	@GetMapping("/munjaeupload1")
	public String munjae1()
	{
		return "uploadmunjae/uploadmumjaeform";
	}
	
	//사진을 업로드 후 json 형태로 파일명 반환
	//ajax 함수를 통해서 호출되는 메서드
	@PostMapping("/munjaeprocess1")
	@ResponseBody
	public Map<String, String> upload1(
			HttpServletRequest request,
			@RequestParam String title,
			@RequestParam("upload") MultipartFile upload
			)
	{
		Map<String,String> map=new HashMap<>();
		//업로드할 경우
		String uploadPath=request.getSession().getServletContext().getRealPath("/save");
		//업로드할 파일명
		String uploadFileName=FileNameChange.getDateChangeFileName(upload.getOriginalFilename());
		
		//업로드
		try {
			upload.transferTo(new File(uploadPath+"/"+uploadFileName));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("photo", uploadFileName);
		map.put("title", title);
		
		return map;	
	}
	
	@GetMapping("/munjaeupload2")
	public String munjae2()
	{
		return "uploadmunjae/munjaeuploadform";
	}
			
	@PostMapping("/munjeprocess2")
	public String multiUpload(
			HttpServletRequest request,
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> uploadList,
			Model model
			)
	{
		//제목부터 모델에 저장
		model.addAttribute("title", title);

		//업로드할 프로젝트내의 위치를 지정(webapp/save)
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");


		//업로드된 파일명을 저장할 리스트변수
		List<String> list=new Vector<>();

		//여러개의 파일들을 업로드(파일명은 뒤에 날짜붙여서 업로드하기)
		for(MultipartFile multiFile:uploadList)
		{
			//업로드할 파일명 구하기
			//String uploadFileName=FilenameChange.getDateChangeFileName(multiFile.getOriginalFilename());
			String uploadFileName=FileNameChange.getRandomChangeFileName(multiFile.getOriginalFilename());
			//사진들 업로드
			try {
				multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//업로드된 파일명 list 에 추가
			list.add(uploadFileName);
		}

		//list 를 모델에 저장
		model.addAttribute("list", list);

		return "uploadmunje/munjeresultview";
	}	
	
	
}
