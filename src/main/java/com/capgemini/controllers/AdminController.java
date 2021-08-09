package com.capgemini.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.model.User;
import com.capgemini.persistance.listUsersDB;

@Controller
@RequestMapping(value ="/admin")
public class AdminController {
	
	ArrayList<User> Users = new ArrayList<User>();
	
	@PostConstruct
	public void startUp() {
		Users = listUsersDB.listUsers();
	}
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView user(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView home(Model model) {			
		return new ModelAndView("redirecto:/");
	}
}
