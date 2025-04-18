package bit.day0417.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import bit.day0417.data.MycarDto;
import bit.day0417.repository.MycarDao;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MycarService {
	
	MycarDao mycarDao;
	
	public Long getTotalCount()
	{
		return mycarDao.getTotalCount();
	}
	
	public void insertCar(MycarDto dto)
	{
		mycarDao.insertCar(dto);
	}
	
	public List<MycarDto> getAllCarList()
	{
		return mycarDao.getAllCarList();
	}
	
	//페이지에 필요한만큼만 가져가는 메서드
	public Page<MycarDto> getAllPageCars(Pageable pageable)
	{
		return mycarDao.getAllPageCars(pageable);//페이지에 필요한만큼만 반환
	}
	
	public MycarDto getData(Long num)
	{
		return mycarDao.getData(num);
	}
	
	public void update(MycarDto dto)
	{
		mycarDao.update(dto);
	}
	
	public void deleteCar(Long num)
	{
		mycarDao.deleteCar(num);
	}
	
	//search
	public List<MycarDto> getSearchList(String search)
	{
		return mycarDao.getSearchList(search);
	}
		
	//search
	public List<MycarDto> findByCarnameContaining(String search)
	{
		return mycarDao.findByCarnameContaining(search);
	}
	
}
