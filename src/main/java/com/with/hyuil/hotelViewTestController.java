package com.with.hyuil;

import com.with.hyuil.config.auth.CustomUserDetails;
import com.with.hyuil.dto.review.StarDto;
import com.with.hyuil.dto.users.BusinessDto;
import com.with.hyuil.dto.users.UsersDto;
import com.with.hyuil.model.*;
import com.with.hyuil.service.FileServiceImpl;
import com.with.hyuil.service.HotelinfoServiceImpl;
import com.with.hyuil.service.OrdersServiceImpl;
import com.with.hyuil.service.RoomServiceImpl;
import com.with.hyuil.service.interfaces.HotelService;
import com.with.hyuil.service.interfaces.ReviewService;
import com.with.hyuil.service.interfaces.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Controller
@Log
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:application.properties")
public class hotelViewTestController {

	private final UsersService usersService;
	private final HotelinfoServiceImpl infoService;
	private final HotelService hotelService;
	private final RoomServiceImpl roomService;
	private final FileServiceImpl fileService;
	private final OrdersServiceImpl ordersService;
	private final ReviewService reviewService;
	@Value("${file.path}")
	private String path;

	@GetMapping("/img") // 로컬파일 C:Imgs에 있는 사진 보여주는 서버
	public ResponseEntity<Resource> display(@Param("filename") String filename) {
		Resource resource = new FileSystemResource(path + filename);
		if (!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

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





	@GetMapping("/hotel/Detail")
	public String messi(@RequestParam long id, Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
		HotelVo hotelvo = hotelService.findByHotelId(id);
		HotelInfoVo infovo = infoService.findByInfoId(hotelvo.getHotelInfoId());
		List<Map<String, Object>> roomList = new ArrayList<Map<String, Object>>();
		roomList = roomService.getroomList(id);
		String[] service = hotelvo.getService().split(" ");
		FileVo filevo = fileService.gethotelImg(infovo.getId());
		if (userDetails != null) {
			String userId = userDetails.getUsername();
			model.addAttribute("userId", userId);
		}
		StarDto star = reviewService.getHotelStar(hotelvo.getId());
		star.calcForHotelList();
		model.addAttribute("star", star);
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
			String userId = userDetails.getUsername();
			UsersVo usersvo = usersService.loginForFind(userId);
			long roomId = Long.parseLong(req.getParameter("id"));
			RoomVo roomvo = roomService.findByRoomId(roomId);
			FileVo filevo = fileService.getRoomImg(roomId);
			HotelVo hotelvo = hotelService.getRoomId(roomId);
			model.addAttribute("userId", userId);
			model.addAttribute("role", userDetails.getAuthorities());
			model.addAttribute("filevo", filevo);
			model.addAttribute("roomvo", roomvo);
			model.addAttribute("usersvo", usersvo);
			model.addAttribute("hotelvo", hotelvo);
			return "/hotel/hotelReserve";

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