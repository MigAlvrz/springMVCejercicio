package com.capgemini.controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.model.User;
import com.capgemini.persistance.*;




@Controller
public class LoginController {
	
	@Autowired @Qualifier("UserDaoImpl")
	private UserDao userDao;

	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		mv.addObject("ErrorMessage", "");
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView home(@RequestParam String user, @RequestParam String contra ,Model model) {
		
		//Aqui conectar a la base de datos y que devuelva un usuario. 
		String userContra = user+" "+contra;
		System.out.println(userContra);
		User NewUser = new User("USER","CONTRA","EMAIL");
	 // return new ModelAndView("redirecto:/home");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		mv.addObject("ErrorMessage", userContra);
		mv.addObject("activeUser", NewUser);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/newUser", method = RequestMethod.POST)
	public ModelAndView newUser(@RequestParam String username, @RequestParam String email, @RequestParam String contra, Model model) {
		String errormessage = "Nuevo usuario añadido";
		
		User newUser = new User(username, email, contra);
		System.out.println(newUser);
		userDao.add(newUser);
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		mv.addObject("ErrorMessage", errormessage);
		mv.setViewName("login");
		return mv;
	}
	
	
	
}
