package com.capgemini.controllers;

import java.lang.ProcessBuilder.Redirect; 

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		mv.addObject("ErrorMessage", "");
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView home(Model model) {
		
		//Aqui conectar a la base de datos y que devuelva un usuario. 
		
		
						
		return new ModelAndView("redirecto:/home/");
	}
	
	
	
}
