package com.with.hyuil;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.with.hyuil.model.HotelInfoVo;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.service.HotelinfoServiceImpl;

@Controller
public class hotelViewTestController {

	@Autowired
	private HotelinfoServiceImpl infoservice;
	@Autowired
	private HotelServiceImpl hotelservice;
	
	@GetMapping("/hotelDetail")
	public String messi() {
		return "/hotel/hotelDetail";
	}
	
	@GetMapping("/hotelForm")
	public String lionel() {
		return "/hotel/hotelForm";
	}
	
	@GetMapping("/hostForm")
	public String balondor() {
		return "/hotel/hostForm";
	}
	
	@GetMapping("/roomForm")
	public String winner() {
		return "/hotel/roomForm";
	}
	
	@PostMapping("/hotelForm")
	public String lionelmessi(HttpServletRequest req, HotelVo hotelvo, HotelInfoVo infovo, MultipartFile file) {
		infoservice.addInfo(infovo);
		String[] service = req.getParameterValues("service");
		String textservice = "";
		for(int i=0; i<service.length; i++) {
			textservice += service[i] + " ";
		}
		hotelvo.setService(textservice);
		hotelvo.setInfoid(infovo.getId());
		System.out.println(hotelvo);
		hotelservice.addHotel(hotelvo);
		return "redirect:/roomForm";
	}
	
}
