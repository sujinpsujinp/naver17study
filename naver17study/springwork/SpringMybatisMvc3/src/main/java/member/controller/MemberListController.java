package member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import data.dto.MemberDto;
import data.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/member")
public class MemberListController {
	
	@Autowired
	MemberService memberService;

	@GetMapping("/list")
	public String memberList(Model model)
	{
		List<MemberDto> list=memberService.getAllMembers();
		model.addAttribute("list",list);
		//model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-56");
		model.addAttribute("fronturl", "https://dqyxjfhq8740.edge.naverncp.com/t0rx4BxTP8");
		model.addAttribute("backurl", "?type=f&w=100&h=120&faceopt=true&ttype=jpg");
		
		return "member/memberlist";
	}
	
}
