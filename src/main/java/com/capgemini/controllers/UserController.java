package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.*;

import com.capgemini.model.User;
import com.capgemini.model.UserBus;

@Controller
@RequestMapping(value ="/user")
public class UserController {
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView user(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		return mv;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public ModelAndView home(ModelMap model) {		
		System.out.println("volviendo al home");
		User activeUser = UserBus.getUser();
		
		model.addAttribute("activeUser", activeUser);
		return new ModelAndView("redirect:/home/", model);
	}

}
