package bit.react.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.react.jwt.JwtUtil;
import bit.react.repository.LoginService;
import bit.react.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {
	
	private final LoginService authService;
	
	@GetMapping("/login")
	public Map<String,String> login(
			@RequestParam("username") String username,
			@RequestParam("password") String password)
	{
		System.out.println("login:"+username+","+password);
		String token=this.authService.login(username, password);
		Map<String,String> map=new HashMap<>();
		map.put("token", token);
		map.put("Authorization","Bearer "+token);//토큰을 보내때 Bearer을 붙여서 보내게 되어있음
		return map;
	}
	
	
}
