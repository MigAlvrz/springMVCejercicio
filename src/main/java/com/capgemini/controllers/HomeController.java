package com.capgemini.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.capgemini.model.Task;
import com.capgemini.model.User;
import com.capgemini.model.UserBus;
import com.capgemini.persistance.ListTasksDB;
import com.capgemini.persistance.UserDao;
import com.capgemini.persistance.insertNewUserDB;
import com.capgemini.persistance.listUsersDB;

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
	
//	@Autowired
//	private ArrayList<Task> tareas = new ArrayList<>();
	@Autowired @Qualifier("UserDaoImpl")
	private UserDao userDao;

	/**
	 * Returns the home view page
	 * @return
	 */

	@RequestMapping(value="/", method = RequestMethod.POST)
	public ModelAndView homePost() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("activeUser", UserBus.getUser()); 
		mv.setViewName("home");
		
		return mv;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView homeGet() {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("activeUser", UserBus.getUser()); 
		
		mv.setViewName("home");
		
		return mv;
	}
	
	
	
	/**
	 * redirects towards the User page
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ModelAndView user(@RequestParam(required=false, name="user") String user ,Model model) {
		System.out.println("Mandando a la página de User");
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		List<User> users = new ArrayList<>();
		User activeUser = UserBus.getUser();
		mv.addObject("activeUser", activeUser);
		mv.setViewName("user");
		return mv;
	}
	/**
	 * Redirects the user towards the admin view page if the user is admin. else it redirects to home
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin", method = RequestMethod.POST)
	public ModelAndView admin(Model model) {
		
		if(true) {
		List<User> users = listUsersDB.listUsers();
		for (User user : users) {
			System.out.println(user.getLogin());
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("Users", users);
		mv.setViewName("admin");
		return mv;
		} else {
			ModelAndView mv = new ModelAndView();
			mv.addObject("activeUser", UserBus.getUser());
			mv.setViewName("home");
			
			return mv;
		}
		
	}
	
	
	
}
