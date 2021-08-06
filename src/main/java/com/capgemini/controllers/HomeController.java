package com.capgemini.controllers;

import java.util.ArrayList; 
import com.capgemini.model.Task;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/home")
public class HomeController {
	
	private ArrayList<Task> tareas = new ArrayList<>();

	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ModelAndView user(Model model) {
		return new ModelAndView("redirecto:/user/");
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public ModelAndView admin(Model model) {
		return new ModelAndView("redirecto:/admin");
	}
	
}
