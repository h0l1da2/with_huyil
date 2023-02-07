package com.with.hyuil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.with.hyuil.model.BusinessVo;
import com.with.hyuil.model.FileVo;
import com.with.hyuil.model.HotelInfoVo;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.model.RoomVo;
import com.with.hyuil.model.UsersVo;
import com.with.hyuil.service.FileServiceImpl;
import com.with.hyuil.service.HotelServiceImpl;
import com.with.hyuil.service.HotelinfoServiceImpl;
import com.with.hyuil.service.RoomServiceImpl;
import com.with.hyuil.service.UsersServiceImpl;

@Controller
@RequestMapping("/host")
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
	
	@RequestMapping("/hotelDetail")
	public String messi(@RequestParam long id, Model model) {
		HotelVo hotelvo = hotelService.findByHotelId(id);
		long hotel_id = hotelvo.getId();
		int count = roomService.roomcnt(hotel_id);
		HotelInfoVo infovo = infoService.findByInfoId(hotel_id);
		model.addAttribute(hotelvo);
		model.addAttribute(infovo);
		model.addAttribute(count);
		
		return "/hotel/hotelDetail";
	}
	
	@GetMapping("/hotelForm")
	public String lionel() {
		return "/hotel/hotelForm";
	}
	
    @GetMapping("/hostForm")
	public String balondor(Model model) {
		String id = "messi";
		UsersVo usersvo = usersService.loginForFind(id);
		System.out.println(usersvo.getBusinessVo());
		model.addAttribute("users", usersvo);
		return "/hotel/hostForm";
	}
	
	@GetMapping("/roomForm")
	public String winner() {
		return "/hotel/roomForm";
	}
	
	@PostMapping("/hostForm")
	public String benzema(BusinessVo businessvo) {
    	String id = "messi";
		UsersVo usersvo = usersService.loginForFind(id);
		return "redirect:/host/hotelForm";
	}
	
	@PostMapping("/hotelForm")
	public ModelAndView lionelmessi(HttpServletRequest req, HttpSession session,
			@ModelAttribute("article") FileVo article, MultipartHttpServletRequest mhsq,
			HotelVo hotelvo, HotelInfoVo infovo, MultipartFile file)throws IllegalStateException, IOException {
		String userId = (String)session.getAttribute("userId");
		UsersVo usersvo = usersService.findByUserid(userId);
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
		//파일 업로드
		String path = "C:/Imgs/";
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		List<MultipartFile> mf = mhsq.getFiles("uploadFile");
		if(mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {
			for (int i=0; i<mf.size(); i++) {
				String genId = UUID.randomUUID().toString();
				String originalfileName = mf.get(i).getOriginalFilename();
				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				String savePath = path + saveFileName;
				long fileSize = mf.get(i).getSize();
				mf.get(i).transferTo(new File(savePath));
				FileVo filevo = new FileVo();
				filevo.setType(FilenameUtils.getExtension(saveFileName));
				filevo.setName(originalfileName);
				filevo.setPath(path);
				filevo.setUuid(saveFileName);
				filevo.setHotel_info_id(infovo.getId());
				filevo.setSize(fileSize);
				fileService.fileUpload(filevo);				
			}
		}
		return new ModelAndView("redirect:/host/roomForm");
	}
	
	@PostMapping("/roomForm")
	public ModelAndView pique(MultipartHttpServletRequest mhsq, HttpSession session, RoomVo roomvo)throws IllegalStateException, IOException {
		String id = (String)session.getAttribute("userId");
		UsersVo usersvo = usersService.findByUserid(id);
		Long userId = usersvo.getId();
		System.out.println(userId);
		HotelVo hotelvo = hotelService.findByHotelUserId(userId);
		System.out.println(hotelvo);
		roomvo.setHotel_id(hotelvo.getId());
		roomService.addRoom(roomvo);
		String path = "C:/Imgs/";
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdirs();
		}
		List<MultipartFile> mf = mhsq.getFiles("uploadFile");
		if(mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {
			for(int i=0; i<mf.size(); i++) {
				String genId = UUID.randomUUID().toString();
				String originalfileName = mf.get(i).getOriginalFilename();
				String saveFileName = genId + "." + FilenameUtils.getExtension(originalfileName);
				String savePath = path + saveFileName;
				long fileSize = mf.get(i).getSize();
				mf.get(i).transferTo(new File(savePath));
				FileVo filevo = new FileVo();
				filevo.setType(FilenameUtils.getExtension(originalfileName));
				filevo.setName(originalfileName);
				filevo.setPath(path);
				filevo.setUuid(saveFileName);
				filevo.setHotel_info_id(hotelvo.getHotelInfoId());
				filevo.setSize(fileSize);
				filevo.setRoom_id(roomvo.getId());
				System.out.println(roomvo);
				fileService.fileUpload(filevo);
			}
		}
		return new ModelAndView("redirect:/host");
	}
}