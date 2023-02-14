package com.with.hyuil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.FileVo;
import com.with.hyuil.model.HotelInfoVo;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.model.OrdersVo;
import com.with.hyuil.model.RoomVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.FileServiceImpl;
import com.with.hyuil.service.HotelServiceImpl;
import com.with.hyuil.service.HotelinfoServiceImpl;
import com.with.hyuil.service.OrdersServiceImpl;
import com.with.hyuil.service.RoomServiceImpl;
import com.with.hyuil.service.UsersServiceImpl;

@Controller
public class hotelViewTestController {

	@Autowired
	private UsersServiceImpl usersService;
	@Autowired
	private HotelinfoServiceImpl infoService;
	@Autowired
	private HotelServiceImpl hotelService;
	@Autowired
	private RoomServiceImpl roomService;	
	@Autowired
	private FileServiceImpl fileService;
	@Autowired
	private OrdersServiceImpl ordersService;
	
	@GetMapping("/host/img") //로컬파일 C:Imgs에 있는 사진 보여주는 서버
	public ResponseEntity<Resource> display(@Param("filename")String filename){
		String path = "C:/Imgs/";
		Resource resource = new FileSystemResource(path + filename);
		if(!resource.exists())
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try {
			filePath = Paths.get(path + filename);
			header.add("Content-Type", Files.probeContentType(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@RequestMapping("/host/hotelDetail")
	public String messi(@RequestParam long id, Model model) {
		HotelVo hotelvo = hotelService.findByHotelId(id);
		HotelInfoVo infovo = infoService.findByInfoId(id);
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		roomList = roomService.getroomList(id);
		String[] service = hotelvo.getService().split(" ");		
		System.out.println(Arrays.toString(service));
		FileVo filevo = fileService.gethotelImg(infovo.getId());
		model.addAttribute("hotelvo", hotelvo);
		model.addAttribute("infovo", infovo);
		model.addAttribute("roomList", roomList);
		model.addAttribute("service", service);
		model.addAttribute("filevo", filevo);
		return "/hotel/hotelDetail";
	}
	
	@GetMapping("/host/hotelForm")
	public String lionel() {
		return "/hotel/hotelForm";
	}
	
    @GetMapping("/host/hostForm")
	public String balondor(Model model, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		UsersDto usersdto = usersService.getId(id);
		BusinessDto businessdto = usersService.findBusinessDto(usersdto.getBusinessId());
		model.addAttribute("business", businessdto);
		model.addAttribute("users", usersdto);
		return "/hotel/hostForm";
	}
	
	@GetMapping("/host/roomForm")
	public String winner() {
		return "/hotel/roomForm";
	}
	
	@GetMapping("/reserve")
	public String reserve(Model model, HttpSession session, HttpServletRequest req, @RequestParam long id) {
		String userId = (String)session.getAttribute("userId");
		UsersVo usersvo = usersService.loginForFind(userId);
		long roomId = Long.parseLong(req.getParameter("id"));
		RoomVo roomvo = roomService.findByRoomId(roomId);
		FileVo filevo = fileService.getRoomImg(roomId);
		model.addAttribute("filevo", filevo);
		model.addAttribute("roomvo", roomvo);
		model.addAttribute("usersvo", usersvo);
		return "/hotel/hotelReserve";
	}
	
	@PostMapping("/host/hostForm")
	public String benzema(HttpSession session, HttpServletRequest req) {
    	String userId = (String)session.getAttribute("userId");
    	UsersDto usersdto = usersService.getId(userId);
    	BusinessDto businessdto = usersService.findBusinessDto(usersdto.getBusinessId());
    	usersdto.setTel(req.getParameter("tel"));
    	businessdto.setBank(req.getParameter("bank"));
    	businessdto.setAccount(req.getParameter("account"));
    	businessdto.setBankNumber(req.getParameter("bankNumber"));
    	usersService.updatehost(usersdto);
    	usersService.updatebusiness(businessdto);    	
    	return "redirect:/host/hotelForm";
	}
	
	@PostMapping("/host/hotelForm")
	public ModelAndView lionelmessi(HttpServletRequest req, HttpSession session,
			@ModelAttribute("article") FileVo article, MultipartHttpServletRequest mhsq,
			HotelVo hotelvo, HotelInfoVo infovo, MultipartFile file)throws IllegalStateException, IOException {
		String userId = (String)session.getAttribute("userId");
		UsersVo usersvo = usersService.loginForFind(userId);
		infoService.addInfo(infovo);
		String[] service = req.getParameterValues("service");
		String textservice = "";
		for(int i=0; i<service.length; i++) {
			textservice += service[i] + " ";
		}
		hotelvo.setUserId(usersvo.getId());
		hotelvo.setService(textservice);
		hotelvo.setHotelInfoId(infovo.getId());
		hotelService.addHotel(hotelvo);
		fileService.UploadImg(mhsq, session, usersvo, hotelvo, null);
		return new ModelAndView("redirect:/host/roomForm");
	}
	
	@PostMapping("/host/roomForm")
	public ModelAndView pique(MultipartHttpServletRequest mhsq, HttpSession session, RoomVo roomvo)throws IllegalStateException, IOException {
		String id = (String)session.getAttribute("userId");
		UsersVo usersvo = usersService.loginForFind(id);
		Long userId = usersvo.getId();
		HotelVo hotelvo = hotelService.findByHotelUserId(userId);
		roomvo.setHotelId(hotelvo.getId());
		roomService.addRoom(roomvo);
		fileService.UploadImg(mhsq, session, usersvo, hotelvo, roomvo);
		return new ModelAndView("redirect:/host");
	}
	
	@PostMapping("/reserve")
	public String rashford(HttpSession session, OrdersVo ordersvo, HttpServletRequest req) {
		String userId = (String)session.getAttribute("userId");
		UsersVo usersvo = usersService.loginForFind(userId);
		System.out.println(req.getParameter("checkin"));
		ordersvo.setUserId(usersvo.getId());
		ordersService.addOrders(ordersvo);
		return "redirect:/";
	}
	
}