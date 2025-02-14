package bitcamp.study;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class BitController {
	
	//@RestController 는 json 출력 시 
	@GetMapping("/hello")
	public List<TestDto> list()
	{
		List<TestDto> list=new Vector<>();
		list.add(new TestDto("강호동","서울","010-2222-5555"));
		list.add(new TestDto("이미자","용인","010-4545-7878"));
		list.add(new TestDto("손철수","제주","010-2542-7855"));
		return list;
		
	}

}
