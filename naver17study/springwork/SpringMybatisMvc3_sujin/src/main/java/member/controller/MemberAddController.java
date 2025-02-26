package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.MemberDto;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/member")
public class MemberAddController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/form")
	public String forn() {
		return "member/member/form";
	}
	
	//아이디가 존재하면 result에 fail, 존재하지 않으면 success를 보내기
	@GetMapping("pathheck")
	@ResponseBody
	public Map<String,String> idCheck(@RequestParam String myid) {
		Map<String, String> map=new HashMap<>();
		if(memberService.isMyidCheck(myid))
			map.put("result", "fail");
		else
			map.put("result", "success");
		return map;
	}
	
	@PostMapping("/insert")
	public String insert(
			HttpServletRequest request,
			@ModelAttribute MemberDto dto,
			@RequestParam("upload") MultipartFile upload
			) {
		//사진선택을 안했을 경우 upload의 파일명을 확인 후
		//사진선택을 안했다면 upload 하지말고 myphoto에 "no" 저장
		System.out.println("filename:"+upload.getOriginalFilename());
		
		return "redirect:/";//일단은 홈으로 이동
	}
	
	
	
	
}
