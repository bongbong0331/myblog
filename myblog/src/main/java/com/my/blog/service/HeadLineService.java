package com.my.blog.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.blog.dto.HeadLineDto;
import com.my.blog.entity.HeadLine;
import com.my.blog.repository.IHeadLineRepository;

@Service
public class HeadLineService {
	
	@Autowired
	private IHeadLineRepository iHeadLineRepository;

	@Transactional
	public HeadLine headLineSave(HeadLineDto headLineDto) {
		String imgOriginName =  headLineDto.getFile().getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		if(imgOriginName.isEmpty() == false) {
			
			String imgFileName = uuid + "_" +  imgOriginName;
			
			Path imgFilePath = Paths.get("C:\\myblog\\myblogimg\\headline\\" + imgFileName);
			
			try {
				Files.write(imgFilePath, headLineDto.getFile().getBytes());
				HeadLine headLineDto2 = headLineDto.toHeadLineEntity(imgFileName);
				iHeadLineRepository.save(headLineDto2);
				
				return headLineDto2;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		HeadLine headLineDto2 = headLineDto.toHeadLineEntity(null);
		return iHeadLineRepository.save(headLineDto2);
	}

	@Transactional
	public HeadLine findByLastDto() {
		return  iHeadLineRepository.findByLastDto();
	}
	
	
}
