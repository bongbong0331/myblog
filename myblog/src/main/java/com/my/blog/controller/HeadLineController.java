package com.my.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.blog.dto.HeadLineDto;
import com.my.blog.entity.HeadLine;
import com.my.blog.service.HeadLineService;

@Controller
public class HeadLineController {
	
	@Autowired
	private HeadLineService headLineService; 

	
	@PostMapping("/upload")
	public String headLineUpload(HeadLineDto headLineDto, Model model) {
		headLineService.headLineSave(headLineDto);
		HeadLine headLineEntity = headLineService.findByLastDto();
		model.addAttribute("headLineEntity", headLineEntity);
		return "index";
	}
}
