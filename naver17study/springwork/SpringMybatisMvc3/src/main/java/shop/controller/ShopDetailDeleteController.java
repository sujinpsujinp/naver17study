package shop.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ShopDetailDeleteController {

	@Autowired
	ShopService shopService;
	
	@GetMapping("shop/detail")
	public String shopDetail(@RequestParam int num, Model model) 
	{
		ShopDto dto=shopService.oneSangpum(num);
		String mainPhoto=dto.getSphoto().split(",")[0];
		dto.setMainPhoto(mainPhoto);
		
		model.addAttribute("dto",dto);
		return "shop/detail";
	}
	
	@GetMapping("shop/delete")
	public String shopDelete(@RequestParam int num,Model model,
			HttpServletRequest request
			)
	{		
		//파일경로 가져오기
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		
		ShopDto dto=shopService.oneSangpum(num);
		
		//파일명을 뽑아서 list에 담음
		String list[]=dto.getSphoto().split("\\,");
		
		//반복문으로 폴더에 있는 사진을 지우기
		for(int i=0;i<list.length;i++)
		{
			//파일 객체를 만든다
			File file=new File(uploadFolder+"/"+list[i]);
		
			file.delete();
		}
		shopService.deleteShop(num);
		return "redirect:./list";
	}
	
}
