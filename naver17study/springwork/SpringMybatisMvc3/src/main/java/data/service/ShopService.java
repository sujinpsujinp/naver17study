package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.ShopDto;
import data.mapper.ShopMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShopService {
	ShopMapper shopMapper;
	
	public int getTotalCount()
	{
		return shopMapper.getTotalCount();
	}
	
	public void insertShop(ShopDto dto)
	{
		shopMapper.insertShop(dto);
	}
	
	public List<ShopDto> getAllSangpum()
	{
		return shopMapper.getAllSangpum();
	}
	
	public ShopDto oneSangpum(int num)
	{
		return shopMapper.oneSangpum(num);
	}
	
	public void updateShop(ShopDto dto)
	{
		shopMapper.updateShop(dto);
	}
	
	public void deleteShop(int num)
	{
		shopMapper.deleteShop(num);
	}
	
}
