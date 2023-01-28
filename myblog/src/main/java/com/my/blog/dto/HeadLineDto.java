package com.my.blog.dto;

import org.springframework.web.multipart.MultipartFile;

import com.my.blog.entity.HeadLine;

import lombok.Data;

@Data
public class HeadLineDto {

	private MultipartFile file;
	private String uuid;
	private String name;
	private String youtubeUrl;
	private String instaUrl; 
	
	public HeadLine toHeadLineEntity(String imgDto) {
		return HeadLine.builder()
		.name(name)
		.img(imgDto)
		.youtubeUrl(youtubeUrl)
		.instaUrl(instaUrl)
		.build();
	}
}
