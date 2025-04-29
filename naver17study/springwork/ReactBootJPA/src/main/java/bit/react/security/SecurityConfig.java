package bit.react.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import bit.react.jwt.JwtAuthFilter;
import bit.react.jwt.JwtUtil;
import bit.react.repository.CustomUserDetailsService;
import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	private final CustomUserDetailsService customUserDetailsService;
	private final JwtUtil jwtUtil;
	
	private static final String[] AUTH_WHITELIST = {
			"/swagger-ui/**", "/api-docs", "/swagger-ui-custom.html",
			"/v3/api-docs/**", "/api-docs/**", "/swagger-ui.html",
			"/api/jpashop/swagger/**"
			};

	
	//비밀번호 암호화에 필요한 메서드
	@Bean
	public BCryptPasswordEncoder bCriptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		//csrf disable- 세션 저장 방식이 아니라 disable 해도 됨
		http
		.csrf(auth->auth.disable());
		
		//form 로그인 방식 사용 안함
		http
		.formLogin(auth->auth.disable());
		
		//http basic 인증방식 사용 안함
		http
		.httpBasic(auth->auth.disable());
		
		http.addFilterBefore(new JwtAuthFilter(customUserDetailsService,jwtUtil), UsernamePasswordAuthenticationFilter.class);
		
		//경로별 인가 작업
		http
		.authorizeHttpRequests(auth->auth
				.requestMatchers("/","/login","/member/**","/react/**").permitAll()
				.requestMatchers(AUTH_WHITELIST).permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()//로그인한 사용자만 접근 
				);
		//세선 설정 -사용 안함
		http
		.sessionManagement(
				session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		
		return http.build();
	}
}
