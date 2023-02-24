package com.with.hyuil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.info.BookAddDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.FileVo;
import com.with.hyuil.model.HotelInfoVo;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.model.OrdersVo;
import com.with.hyuil.model.RoomVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.BookServiceImpl;
import com.with.hyuil.service.FileServiceImpl;
import com.with.hyuil.service.HotelServiceImpl;
import com.with.hyuil.service.HotelinfoServiceImpl;
import com.with.hyuil.service.OrdersServiceImpl;
import com.with.hyuil.service.RoomServiceImpl;
import com.with.hyuil.service.UsersServiceImpl;

import lombok.Setter;
import lombok.extern.java.Log;

@Controller
@Log
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
	@Autowired
	private BookServiceImpl bookService;

	@GetMapping("/img") // 로컬파일 C:Imgs에 있는 사진 보여주는 서버
	public ResponseEntity<Resource> display(@Param("filename") String filename) {
		String path = "C:/Imgs/";
		Resource resource = new FileSystemResource(path + filename);
		if (!resource.exists())
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);

		HttpHeaders header = new HttpHeaders();
		Path filePath = null;
		try {
			filePath = Paths.get(path + filename);
			header.add("Content-Type", Files.probeContentType(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
	}
	
	@Setter(onMethod_ = @Autowired)
    private KakaoPay kakaopay;
    
    
 
    @PostMapping("/kakaoPay")
    public String kakaoPay(HttpServletRequest req, @RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate checkin,
    		@RequestParam("checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate checkout, @RequestParam("roomId") long roomId) {
        log.info("kakaoPay post............................................");
        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");
        int price = Integer.parseInt(req.getParameter("price"));
        String name = req.getParameter("name");
        String please = req.getParameter("please");
		int date = (ordersService.getDatesBetweenTwoDates(checkin, checkout)).size();
		int total_amountint = price * date;
		String day = String.valueOf(date);
		String total_amount = Integer.toString(total_amountint);
		String checkinstr = checkin.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String checkoutstr = checkout.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String daytoday = checkinstr + " ~ " + checkoutstr;
		return "redirect:" + kakaopay.kakaoPayReady(name, userId, userName, total_amount, day, daytoday, roomId, please);
    }
    
    @RequestMapping("/kakaoPaySuccess")
    public String Kim(HttpServletRequest req, Model model,@RequestParam("pg_token") String pg_token, @RequestParam("userId") String userId, @RequestParam("totalPrice") int totalPrice,
    				@RequestParam("userName") String userName, @RequestParam("day") String day, @RequestParam("item") String item, @RequestParam("roomId") long roomId, 
    				@RequestParam("please") String please, RedirectAttributes re) {
    	UsersVo usersvo = usersService.loginForFind(userId);
    	RoomVo roomvo = roomService.findByRoomId(roomId);
    	HotelVo hotelvo = hotelService.findByHotelId(roomvo.getHotelId());
    	String total_amount = String.valueOf(totalPrice);
    	OrdersVo ordersvo = new OrdersVo();
    	ordersvo.setUserId(usersvo.getId());
    	ordersvo.setTotalPrice(totalPrice);
    	String date[] = day.split(" ~ ");
    	LocalDate checkIn = LocalDate.parse(date[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	LocalDate checkOut = LocalDate.parse(date[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    	ordersvo.setCheckin(checkIn);
    	ordersvo.setCheckout(checkOut);
    	long hostId = hotelService.getHostId(hotelvo.getId());
    	ordersvo.setHostId(hostId);
    	ordersvo.setTid(kakaopay.kakaoPayInfo(pg_token, total_amount).getTid());
    	ordersvo.setUserName(userName);
    	String hotelRoom[] = item.split(" / ");
    	ordersvo.setHotel(hotelRoom[0]);
    	ordersvo.setRoom(hotelRoom[1]);
    	ordersvo.setPgToken(pg_token);
    	ordersService.addOrders(ordersvo);
    	BookAddDto bookAddDto = new BookAddDto();
    	bookAddDto.setUserId(usersvo.getId());
    	bookAddDto.setRoomId(roomId);
    	bookAddDto.setPlease(please);
    	Date check1 = java.sql.Date.valueOf(checkIn);
    	Date check2 = java.sql.Date.valueOf(checkOut);
    	bookAddDto.setCheckIn(check1);
    	bookAddDto.setCheckOut(check2);
    	bookAddDto.setOrderId(ordersvo.getId());
    	bookService.addBook(bookAddDto);
    	re.addAttribute("pg_token", pg_token);
    	return "redirect:/orderComplete";
    }
    
    @GetMapping("/orderComplete")
    public String MinJae(Model model, @RequestParam("pg_token") String pgToken){
    	OrdersVo ordersvo = ordersService.findByToken(pgToken);
    	String now = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초").format(ordersvo.getOrderDate());
    	model.addAttribute("now", now);
    	model.addAttribute("orders", ordersvo);
    	return "/order/orderComplete";
    }
    
    @GetMapping("/hotel/kakaoPayCancel")
    public String Wall() {
    	return "/order/kakaoPayCancel";
    }
	
	@GetMapping("/hotel/Detail")
	public String messi(@RequestParam long id, Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		HotelVo hotelvo = hotelService.findByHotelId(id);
		HotelInfoVo infovo = infoService.findByInfoId(hotelvo.getHotelInfoId());
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		roomList = roomService.getroomList(id);
		String[] service = hotelvo.getService().split(" ");
		System.out.println(Arrays.toString(service));
		FileVo filevo = fileService.gethotelImg(infovo.getId());
		if (userDetails != null) {
			String userId = userDetails.getUsername();
			model.addAttribute("userId", userId);
		}
		model.addAttribute("hotelvo", hotelvo);
		model.addAttribute("infovo", infovo);
		model.addAttribute("roomList", roomList);
		model.addAttribute("service", service);
		model.addAttribute("filevo", filevo);
		return "/hotel/hotelDetail";
	}

	@GetMapping("/hosts/hotelForm")
	public String lionel(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		if (userDetails != null) {
			String userId = userDetails.getUsername();
			UsersVo usersvo = usersService.loginForFind(userId);
			HotelVo hotelvo = hotelService.findByHotelUserId(usersvo.getId());
			model.addAttribute("userId", userId);
			if (hotelvo != null) {
				HotelInfoVo infovo = infoService.findByInfoId(hotelvo.getHotelInfoId());
				FileVo filevo = fileService.gethotelImg(infovo.getId());
				model.addAttribute("filevo", filevo);
				model.addAttribute("infovo", infovo);
				model.addAttribute("hotelvo", hotelvo);
				model.addAttribute("usersvo", usersvo);
				List<Map<String, Object>>roomlist = roomService.getroomList(hotelvo.getId());
				if(roomlist.size() != 0) {
					model.addAttribute("roomlist", roomlist);
				}
			}
			return "/hotel/hotelForm";
		} else {
			return "/user/loginForm";
		}
	}

	@GetMapping("/hosts/hostForm")
	public String balondor(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		if (userDetails != null) {
			String id = userDetails.getUsername();
			UsersDto usersdto = usersService.getId(id);
			BusinessDto businessdto = usersService.findBusinessDto(usersdto.getBusinessId());
			model.addAttribute("business", businessdto);
			model.addAttribute("users", usersdto);
			return "/hotel/hostForm";
		} else {
			return "/user/loginForm";
		}
	}

	@GetMapping("/hosts/roomForm")
	public String winner(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		if (userDetails != null) {
			String userId = userDetails.getUsername();
			UsersVo usersvo = usersService.loginForFind(userId);
			HotelVo hotelvo = hotelService.findByHotelUserId(usersvo.getId());
			model.addAttribute("userId", userId);
			if(hotelvo == null) {
				return "/hotel/hotelForm";
			}
			return "/hotel/roomForm";
		} else {
			return "/user/loginForm";
		}
	}

	@GetMapping("/reserve")
	public String reserve(Model model, @AuthenticationPrincipal CustomUserDetails userDetails, HttpServletRequest req, @RequestParam long id) {
		if(userDetails == null) {
			return "user/loginForm";
		}else {
			String userId = userDetails.getUsername();
			UsersVo usersvo = usersService.loginForFind(userId);
			long roomId = Long.parseLong(req.getParameter("id"));
			RoomVo roomvo = roomService.findByRoomId(roomId);
			FileVo filevo = fileService.getRoomImg(roomId);
			HotelVo hotelvo = hotelService.getRoomId(roomId);
			model.addAttribute("userId", userId);
			model.addAttribute("filevo", filevo);
			model.addAttribute("roomvo", roomvo);
			model.addAttribute("usersvo", usersvo);
			model.addAttribute("hotelvo", hotelvo);
			return "/hotel/hotelReserve";
		}
	}

	@GetMapping("/hosts/roomList")
	public String Harry(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		if(userDetails == null) {
			return "user/loginForm";
		}else {
			String userId = userDetails.getUsername();
			UsersVo usersvo = usersService.loginForFind(userId);
			HotelVo hotelvo = hotelService.findByHotelUserId(usersvo.getId());
			List<Map<String, Object>> roomlist = roomService.getroomList(hotelvo.getId());
			model.addAttribute("userId", userId);
			model.addAttribute("roomlist", roomlist);
			return "/hotel/roomList";
		}
	}
	
	@GetMapping("/hosts/roomEdit")
	public String Kane(Model model, @AuthenticationPrincipal CustomUserDetails userDetails, @RequestParam("id")long id) {
		if(userDetails == null) {
			return "user/loginForm";
		}else {
			String userId = userDetails.getUsername();
			RoomVo roomvo = roomService.findByRoomId(id);
			FileVo filevo = fileService.getRoomImg(roomvo.getId());
			model.addAttribute("roomvo", roomvo);
			model.addAttribute("userId", userId);
			model.addAttribute("filevo", filevo);
			return "/hotel/roomEdit";
		}
	}
	
	@GetMapping("/hosts/cashUp")
	public String Karim(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		if(userDetails == null) {
			return "user/loginForm";
		}else {
			String userId = userDetails.getUsername();
			UsersVo usersvo = usersService.loginForFind(userId);
			List<Map<String, Object>> list = ordersService.getOrderList(usersvo.getId());
			System.out.println(list);
			model.addAttribute("list", list);
			model.addAttribute("userId", userId);
			
			return "/hotel/cashUp";
		}
	}
	
	@PostMapping("/hosts/delHotel")
	public String delHotel(HttpServletRequest req, FileVo filevo, HotelInfoVo infovo, HotelVo hotelvo) {
		long infoId = Long.parseLong(req.getParameter("infoId"));
		long hotelId = Long.parseLong(req.getParameter("hotelId"));
		filevo.setHotelInfoId(infoId);
		fileService.deleteHotelImg(filevo);
		infovo.setId(infoId);
		infoService.delInfo(infovo);
		hotelvo.setId(hotelId);
		hotelService.delHotel(hotelvo);
		return "/hotel/hotelForm";
	}
	
	@PostMapping("/hosts/delRoom")
	public String delRoom(HttpServletRequest req, RoomVo roomvo, FileVo filevo) {
		long roomId = Long.parseLong(req.getParameter("roomId"));
		filevo.setRoomId(roomId);
		roomvo.setId(roomId);
		fileService.deleteRoomImg(filevo);
		roomService.delRoom(roomvo);
		return "redirect:/hosts/roomList";
	}

	@PostMapping("/hosts/hostForm")
	public String benzema(@AuthenticationPrincipal CustomUserDetails userDetails, HttpServletRequest req) {
		String userId = userDetails.getUsername();
		UsersDto usersdto = usersService.getId(userId);
		BusinessDto businessdto = usersService.findBusinessDto(usersdto.getBusinessId());
		usersdto.setTel(req.getParameter("tel"));
		businessdto.setBank(req.getParameter("bank"));
		businessdto.setAccount(req.getParameter("account"));
		businessdto.setBankNumber(req.getParameter("bankNumber"));
		usersService.updatehost(usersdto);
		usersService.updatebusiness(businessdto);
		return "redirect:/hosts/hotelForm";
	}

	@PostMapping("/hosts/hotelForm")
	public ModelAndView lionelmessi(HttpServletRequest req, @AuthenticationPrincipal CustomUserDetails userDetails, FileVo filevo,
									MultipartHttpServletRequest mhsq, HotelInfoVo infovo, HotelVo hotelvo, MultipartFile file) throws IllegalStateException, IOException {
		String userId = userDetails.getUsername();
		UsersVo usersvo = usersService.loginForFind(userId);
		if(hotelService.findByHotelUserId(usersvo.getId()) == null) {
			infoService.addInfo(infovo);
			String hotelservice = req.getParameter("service");
			if(hotelservice != null) {
				String[] service = req.getParameterValues("service");
				String textservice = "";
				for (int i = 0; i < service.length; i++) {
					textservice += service[i] + " ";
				}
				hotelvo.setUserId(usersvo.getId());
				hotelvo.setHotelInfoId(infovo.getId());
				hotelvo.setService(textservice);
			}
			hotelService.addHotel(hotelvo);
			fileService.UploadImg(mhsq, usersvo, hotelvo, null);
			return new ModelAndView("redirect:/hosts/roomForm");
		}else {
			hotelvo = hotelService.findByHotelUserId(usersvo.getId());
			infovo = infoService.findByInfoId(hotelvo.getHotelInfoId());
			if(mhsq.getFile("uploadFile").getSize() != 0) {
				filevo.setHotelInfoId(infovo.getId());
				fileService.deleteHotelImg(filevo);
				fileService.UploadImg(mhsq, usersvo, hotelvo, null);
			}
			String hotelservice = req.getParameter("service");
			if(hotelservice != null) {
				String[] service = req.getParameterValues("service");
				String textservice = "";
				for (int i = 0; i < service.length; i++) {
					textservice += service[i] + " ";
				}
				hotelvo.setService(textservice);
			}
			hotelvo.setName(req.getParameter("name"));
			hotelvo.setAddress(req.getParameter("address"));
			hotelvo.setDetail(req.getParameter("detail"));
			hotelvo.setSido(req.getParameter("sido"));
			hotelvo.setSigungu(req.getParameter("sigungu"));
			hotelvo.setZonecode(req.getParameter("zonecode"));
			infovo.setCheckIn(req.getParameter("checkIn"));
			infovo.setCheckOut(req.getParameter("checkOut"));
			infovo.setIntro(req.getParameter("intro"));
			infovo.setPolicy(req.getParameter("policy"));
			infovo.setSpot(req.getParameter("spot"));
			infovo.setTraffic(req.getParameter("traffic"));
			infoService.updateInfo(infovo);
			hotelService.updateHotel(hotelvo);
			return new ModelAndView("redirect:/hosts/roomForm");
		}
	}

	@PostMapping("/hosts/roomForm")
	public ModelAndView pique(MultipartHttpServletRequest mhsq, @AuthenticationPrincipal CustomUserDetails userDetails, RoomVo roomvo)
			throws IllegalStateException, IOException {
		String id = userDetails.getUsername();
		UsersVo usersvo = usersService.loginForFind(id);
		Long userId = usersvo.getId();
		HotelVo hotelvo = hotelService.findByHotelUserId(userId);
		roomvo.setHotelId(hotelvo.getId());
		roomService.addRoom(roomvo);
		fileService.UploadImg(mhsq, usersvo, hotelvo, roomvo);
		return new ModelAndView("redirect:/hosts/roomList");
	}
	
	@PostMapping("/hosts/roomEdit")
	public ModelAndView roomEdit(MultipartHttpServletRequest mhsq, @AuthenticationPrincipal CustomUserDetails userDetails,
							HttpServletRequest req, RoomVo roomvo, FileVo filevo)throws IllegalStateException, IOException {
		long id = Long.parseLong(req.getParameter("roomId"));
		String userId = userDetails.getUsername();
		UsersVo usersvo = usersService.loginForFind(userId);
		HotelVo hotelvo = hotelService.getRoomId(id);
		roomvo.setId(id);
		if(mhsq.getFile("uploadFile").getSize() != 0) {
			filevo.setRoomId(id);
			fileService.deleteRoomImg(filevo);
			fileService.UploadImg(mhsq, usersvo, hotelvo, roomvo);
		}
		roomService.updateRoom(roomvo);
		return new ModelAndView("redirect:/hosts/roomList");
	}

}