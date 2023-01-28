package com.my.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my.blog.entity.HeadLine;
import com.my.blog.service.HeadLineService;

@Controller
public class MainController {

	@Autowired
	private HeadLineService headLineService;
	
	
	@GetMapping({"", "/"})
	public String main(Model model) {
		HeadLine headLineEntity = headLineService.findByLastDto();
		model.addAttribute("headLineEntity", headLineEntity);
		return "index";
	}
}
