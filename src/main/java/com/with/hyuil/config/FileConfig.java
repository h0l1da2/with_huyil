package com.with.hyuil.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.with.hyuil.model.FileVo;

@Component
public class FileConfig {

	public List<FileVo> fileinfo(Long Fileid, List<MultipartFile> multipartFiles) throws Exception {
		UUID uuid = UUID.randomUUID();
		List<FileVo> fileList = new ArrayList<>();
		if(multipartFiles.isEmpty()) {
			return fileList;
		}
		String imagePath = new File("").getAbsolutePath() + "\\";
		String path = "C://Users//kim//Desktop//images/";
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				String contentType = multipartFile.getContentType();
				String originalFileExtension;
				if(ObjectUtils.isEmpty(contentType)) {
					break;
				}else {
					if(contentType.contains("image/jpeg")) {
						originalFileExtension = ".jpg";
					} else if(contentType.contains("image/png")) {
						originalFileExtension = ".png";
					}else {
						break;
					}
				}
				FileVo filevo = FileVo.builder()
						.uuid(uuid + "_" + multipartFile.getOriginalFilename())
						.name(multipartFile.getOriginalFilename())
						.type(originalFileExtension)
						.path(path)
						.size(multipartFile.getSize())
						.build();
				fileList.add(filevo);
				file = new File(imagePath + path + "/" + uuid + originalFileExtension);
				multipartFile.transferTo(file);
			}
		}
		return fileList;
	}
}