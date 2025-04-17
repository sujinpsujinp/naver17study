package bit.day0417.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.day0417.data.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarDao {
	
	MycarRepository mycarRepository;
	
	public long getTotalCount()
	{
		//return mycarRepository.count();//전체 갯수 반환 JPA가 기본으로 갖고있음
		return mycarRepository.getTotalMycount();//내가 직접 쿼리문으로 작성한 메서드, 결과는 위와 같다
	}

	public void insertCar(MycarDto dto)
	{
		//save 메서드는 기본 제공하는 메서드인데 추거와 수정을 모두 담당
		//num 값이 dto에 포하되어있을 경우 자동으로 수정되고
		//없을경우 추가가 된다.
		mycarRepository.save(dto);
	}
	
	public List<MycarDto> getAllCarList()
	{
		//return mycarRepository.findAll();//추가한 순서대로
		//return mycarRepository.findAll(Sort.by(Sort.Direction.DESC,"carprice"));//단가의 내림차순으로 정렬해서 출력
		//return mycarRepository.findAll(Sort.by(Sort.Direction.ASC,"carprice"));//단가의 오름차순으로 정렬해서 출력
		return mycarRepository.findAll(Sort.by(Sort.Direction.ASC,"carguip"));//구입일의 오름차슨으로 정렬해서 출력
	}
	
	public MycarDto getData(Long num)
	{
		return mycarRepository.getReferenceById(num);
	}
	
	public void update(MycarDto dto)
	{
		mycarRepository.save(dto);//이번에는 num이 포함되어있으므로 수정이 된다
	}
	
	public void deleteCar(Long num)
	{
		mycarRepository.deleteById(num);
	}
	
}
