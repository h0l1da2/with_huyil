package com.with.hyuil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.with.hyuil.dao.FileMapper;
import com.with.hyuil.model.FileVo;

@Service
public class FileServiceImpl {
	
	@Autowired
	private FileMapper mapper;

	public void fileUpload(FileVo filevo) {
		mapper.uploadFile(filevo);
	}
	
}