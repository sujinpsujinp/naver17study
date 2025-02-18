package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.test.TestDto;

@Controller //bean 객체를 자동등록 
//@RestController로 할 경우 무조건 json으로만 처리 가능, 포워드나 리다이렉트 안됨
//이 경우 @ResponseBody 안붙여도 됨
public class HelloController {
	
	//@RequestMapping(value="/", method = RequestMethod.GET) //스프링 모든 버전에서 가능
	//@RequestMapping("/") //method 방식 생략 시 기본이 get
	@GetMapping("hello2") //스프링5부터 가능
	@ResponseBody public TestDto hello() //json형식으로 바로 브라우저에 출력
	{
		TestDto dto=new TestDto();
		dto.setAddr("222");
		dto.setName("이영자");
		dto.setHp("010-1234-5678");
		System.out.println(dto);//ToString도 들어가있는지 확인
		return dto;
		
	}
}
