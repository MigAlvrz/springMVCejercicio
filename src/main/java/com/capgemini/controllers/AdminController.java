package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/admin")
public class AdminController {
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView user(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView home(Model model) {			
		return new ModelAndView("redirecto:/home/");
	}
}
