package bit.react.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public void joinProcess(JoinDto dto) {
		// TODO Auto-generated method stub
		
		UserEntity data=UserEntity.builder()
				.username(dto.getUsername())
				.password(bCryptPasswordEncoder.encode(dto.getPassword()))
				.role(dto.getRole())
				.address(dto.getAddress())
				.build();
		
		//db에 저장
		userRepository.save(data);
		
	}
	
}
