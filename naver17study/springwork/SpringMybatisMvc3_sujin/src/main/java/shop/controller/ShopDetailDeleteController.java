package shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String shopDelete(@RequestParam int num,
			HttpServletRequest request
			)
	{		
		//파일경로 가져오기
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		
		//이건 전날 내가 한 코드들
		//ShopDto dto=shopService.oneSangpum(num);
		//파일명을 뽑아서 list에 담음
		//String list[]=dto.getSphoto().split("\\,");
		
		//반복문으로 폴더에 있는 사진을 지우기 >> 내가 한 코드
//		for(int i=0;i<list.length;i++)
//		{
//			//파일 객체를 만든다
//			File file=new File(uploadFolder+"/"+list[i]);
//		
//			file.delete();
//		}
		
		//삭제전에 사진명을 얻어야한다 이 아래는 쌤이 짠 코드
		String photos=shopService.oneSangpum(num).getSphoto();
		//,로 분리
		String []photo=photos.split("\\,");
		
		//쌤이 짠 코드
		//실제 경로에서 파일을 찾아서 삭제
		for(String f:photo)
		{
			File file=new File(uploadFolder+"/"+f);
			//save 폴더에 파일이 존자할 경우 삭제
			if(file.exists())
				file.delete();
		}
		//db 데이터 삭제
		shopService.deleteShop(num);
		
		return "redirect:./list";
	}
	
	@GetMapping("/shop/photos")
	public String shopPhotos(@RequestParam int num,Model model) 
	{
		//num에 해당하는 사진 얻기
		String sphoto=shopService.oneSangpum(num).getSphoto();
		model.addAttribute("sphoto",sphoto);
		model.addAttribute("num",num);
		return "shop/photos";
	}
	
	@GetMapping("/shop/delphoto")
	@ResponseBody
	public void deletePhoto(@RequestParam int num,@RequestParam String pname,
			HttpServletRequest request) 
	{
		//업로드 경로 가져오기
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		//스토리지의 사진도 삳제
		File file=new File(uploadFolder+"/"+pname);
		if(file.exists())
			file.delete();
		
		//num에 해당하는 sphoto를 db에서 얻는다
		String sphoto=shopService.oneSangpum(num).getSphoto();
		
		//sphoto에서 pname부분을 삭제하는데 중간일 경우 뒤에 컴마도 삭제
		String changephoto="";
		if(sphoto.endsWith(pname)) {
			changephoto=sphoto.replace(pname, "");
		}
			
		else
			changephoto=sphoto.replace(pname+",", "");
		
		System.out.println(changephoto);
		//그 변경된 changephoto를 updatePhoto를 통해서 보낸다
		shopService.updatephoto(num, changephoto);
	}
	
	@PostMapping("/shop/addphoto")
	@ResponseBody
	public void addPhoto(@RequestParam int num,@RequestParam("upload") List<MultipartFile> uploadList,
			HttpServletRequest request) 
	{
		//업로드 경로 구하기
		String uploadFolder=request.getSession().getServletContext().getRealPath("/save");
		//새로 업로드할 파일명 구할 변수
		String photos="";
		for(MultipartFile f:uploadList)
		{
			//업로드할 파일명
			String uploadFilename=UUID.randomUUID()+"."+f.getOriginalFilename().split("\\.")[1];
			photos+=uploadFilename+",";
			//업로드
			try {
				f.transferTo(new File(uploadFolder+"/"+uploadFilename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//마지막 컴마 제거
		photos=photos.substring(0,photos.length()-1);
		//db에서의 sphoto 얻기
		String sphoto=shopService.oneSangpum(num).getSphoto();
		//sphoto가 값이 없을 경우 photos를 대입하고 이미 있는 경우 ,를 추가후 photos추가
		if(sphoto.length()==0)
			sphoto=photos;
		else
			sphoto=sphoto+","+photos;
		shopService.updatephoto(num, sphoto);
	}
	
	
}
