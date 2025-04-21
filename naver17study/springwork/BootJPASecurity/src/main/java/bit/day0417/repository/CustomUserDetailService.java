package bit.day0417.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bit.day0417.data.UserEntity;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService{
	
	private UserRepository userRepository;
	
	//로그인 시 Spring SecurityConfig 검증을 위해서 username을 넣어준다.
	/*"/login" 경롤로 POST 요청이 오면
	 * 스프링
	 * */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userData=userRepository.findByUsername(username);
		if(userData==null) {
			System.out.println(username+" 아이디는 DB에 존재하지 않음!");
		}else {
			System.out.println(username+" 아이디로 로그인함!");
			return new CustomUserDetail(userData);
		}
		return null;
	}

}
