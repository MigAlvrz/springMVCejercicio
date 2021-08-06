package com.capgemini.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.capgemini.model.Task;
import com.capgemini.model.User;
import com.capgemini.model.UserBus;
import com.capgemini.persistance.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/home")
public class HomeController {
	
	private ArrayList<Task> tareas = new ArrayList<>();
	@Autowired @Qualifier("UserDaoImpl")
	private UserDao userDao;


	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping(value="/activeUser", method = RequestMethod.POST)
	public ModelAndView user(@RequestParam(required=false, name="user") String user ,Model model) {
		System.out.println("Mandando a la página de User");
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		List<User> users = new ArrayList<>();
		User activeUser = new User();
		users = userDao.getUsers();
		for (User usuario : users) {
			System.out.println(usuario.getLogin());
			if (usuario.getLogin().equals(user))
				activeUser = usuario;
		}
		activeUser = UserBus.getUser();
		if(activeUser.getLogin()!=null) {
			mv.addObject("activeUser", activeUser);
			mv.setViewName("user");
			return mv;
		}
			System.out.println(activeUser.getLogin());
			System.out.println("TESTERINO");
			System.out.println(activeUser);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public ModelAndView admin(Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		return mv;
	}
	
}
