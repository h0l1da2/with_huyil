package com.with.hyuil.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.with.hyuil.dao.FileMapper;
import com.with.hyuil.model.FileVo;
import com.with.hyuil.model.HotelVo;
import com.with.hyuil.model.RoomVo;
import com.with.hyuil.model.UsersVo;

@Service
public class FileServiceImpl {

	@Autowired
	private FileMapper mapper;

	public void fileUpload(FileVo filevo) {
		mapper.uploadFile(filevo);
	}

	public FileVo gethotelImg(long hotelInfoId) {
		return mapper.selecthotelImg(hotelInfoId);
	}

	public FileVo getRoomImg(long roomId) {
		return mapper.selectRoomImg(roomId);
	}

	public void UploadImg(MultipartHttpServletRequest mhsq, UsersVo usersvo, HotelVo hotelvo, RoomVo roomvo)throws IllegalStateException, IOException  {
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
				filevo.setHotelInfoId(hotelvo.getHotelInfoId());
				filevo.setSize(fileSize);
				if(roomvo != null) {
					filevo.setRoomId(roomvo.getId());
				}
				fileUpload(filevo);
			}
		}
	}
	
	public long deleteHotelImg(long hotelInfoId) {
		return mapper.deleteHotelImg(hotelInfoId);
	}
	
}