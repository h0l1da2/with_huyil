package com.with.hyuil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.with.hyuil.model.FileVo;
import com.with.hyuil.model.HotelInfoVo;
import com.with.hyuil.model.HotelVo;

import com.with.hyuil.service.HotelinfoServiceImpl;
import com.with.hyuil.service.RoomServiceImpl;

@Controller
@RequestMapping("/host")
public class hotelViewTestController {

	@Autowired
	private HotelinfoServiceImpl infoService;
	@Autowired
	private HotelServiceImpl hotelService;
	@Autowired
	private RoomServiceImpl roomService;	
	@Autowired
	private FileServiceImpl fileService;
	
	@GetMapping("/hotelDetail")
	public String messi() {
		return "/hotel/hotelDetail";
	}
	
	@GetMapping("/hotelForm")
	public String lionel() {
		return "/hotel/hotelForm";
	}
	
	@GetMapping("/roomForm")
	public String winner() {
		return "/hotel/roomForm";
	}
	
	@PostMapping("/hotelForm")
	public ModelAndView lionelmessi(HttpServletRequest req,
			@ModelAttribute("article") FileVo article, MultipartHttpServletRequest mhsq,
			HotelVo hotelvo, HotelInfoVo infovo, MultipartFile file)throws IllegalStateException, IOException {
		infoService.addInfo(infovo);
		String[] service = req.getParameterValues("service");
		String textservice = "";
		for(int i=0; i<service.length; i++) {
			textservice += service[i] + " ";
		}
		hotelvo.setService(textservice);
		hotelvo.setInfoid(infovo.getId());
		hotelService.addHotel(hotelvo);
		//파일 업로드
		String path = "C:/Users/USER/Desktop/imges/";
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
				filevo.setType("null");
				filevo.setName(originalfileName);
				filevo.setPath(path);
				filevo.setUuid(saveFileName);
				filevo.setHotel_info_id(infovo.getId());
				filevo.setSize(fileSize);
				filevo.setRoom_id(0);
				fileService.fileUpload(filevo);
			}
		}
		return new ModelAndView("redirect:/host/roomForm");
	}
	
	@PostMapping("/roomForm")
	public String pique(RoomVo roomvo) {
		long id = 170;
		HotelVo hotelvo = hotelService.findByHotelId(id);
		roomvo.setHotel_id(hotelvo.getId());
		roomService.addRoom(roomvo);
		return "redirect:/host";
	}
	
}