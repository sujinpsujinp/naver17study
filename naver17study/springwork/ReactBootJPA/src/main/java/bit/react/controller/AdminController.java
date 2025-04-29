package bit.react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import bit.react.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AdminController {
	
	private final JwtUtil jwtUtil;
	
	@GetMapping("/admin")
	public String admin(HttpServletRequest request)
	{
		//header로부터 Authorization을 얻는다
		String auth=request.getHeader("Authorization");
		//Bearer을 제거한 순수 토큰을 얻는다 7번부터 얻어야지 순수 토큰을 얻음
		String token=auth.substring(7);
		//토큰만 있으면 username 정보와 role 정보를 얻을 수 있다.
		String username=jwtUtil.getUsername(token); //로그인한 아이디
		String role=jwtUtil.getRole(token);//로그인한 role
		return "admin ok! username: " + username + ", role: " + role;
	}
}
