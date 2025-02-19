package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.ShopDto;
import data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShopUpdateController {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/shop/updateform")
	public String updateForm(@RequestParam int num,Model model)
	{
		ShopDto dto=shopService.oneSangpum(num);
		
		model.addAttribute("dto", dto);
		return "shop/updateform";
	}
	
	@PostMapping("/shop/update")
	public String update(
			@ModelAttribute ShopDto dto
			)
	{
		//db update
		shopService.updateShop(dto);
		return "redirect:./detail?num="+dto.getNum();
	}

}
