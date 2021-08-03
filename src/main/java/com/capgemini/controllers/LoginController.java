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
	public String login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "Get Tasks done!");
		mv.addObject("ErrorMessage", "");
		mv.setViewName("login");
		return "login";
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView home(Model model) {
		
		//Aqui conectar a la base de datos y que devuelva un usuario. 
		
		
						
		return new ModelAndView("redirecto:/home/");
	}
	
	
	
}
