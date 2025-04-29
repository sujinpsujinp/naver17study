package bit.react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.react.data.JoinDto;
import bit.react.repository.JoinService;
import bit.react.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class JoinController {
	private final JoinService joinService;
	private final UserRepository userRepository;
	
	@GetMapping("/idcheck")
	public String idCheck(@RequestParam("username") String username)
	{
		Boolean isExist=userRepository.existsByUsername(username);
		if(isExist)
		{
			System.out.println("db에 이미 존재함! 가입 안됨");
			return "fail";
		}else 
			return "success";
	}
	
	@PostMapping("/join")
	public String joinProcess(@RequestBody JoinDto dto)
	{
		joinService.joinProcess(dto);
		return "success";
	}
}
