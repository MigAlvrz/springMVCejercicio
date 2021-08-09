package com.capgemini.controllers;

import java.lang.ProcessBuilder.Redirect; 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

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
import com.capgemini.model.UserBus;
import com.capgemini.persistance.*;




@Controller
public class LoginController {
	
	@Autowired @Qualifier("UserDaoImpl")
	private UserDao userDao;
	
	CreateDB createDB = new CreateDB();
	LoginDB loginDB = new LoginDB();
	UpdateStatusAdminDB updateStatusDB = new UpdateStatusAdminDB();
	listUsersDB listUsersDB = new listUsersDB();
	ArrayList<User> users = new ArrayList<>();
	
//  al comentar esto, funciona
//	@Autowired
//	private UserRepository userRepository;


	@PostConstruct
	public void startUp() {
		createDB.crearDB();
		users = listUsersDB.listUsers();
	}
	
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
		User activeUser = null;
		System.out.println(this.users.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		for (User user2 : this.users) {
			System.out.println(user2.getLogin()+" "+user2.getPassword());
			if(user2.getLogin().equals(user)&&user2.getPassword().equals(contra)){
				activeUser = user2;
				UserBus.setUser(user2);
				System.out.println(activeUser.getLogin());
			}
		}
		if(activeUser != null) {
		UserBus.setUser(activeUser);	
		mv.addObject("ErrorMessage", "");
		mv.addObject("activeUser", activeUser);
		mv.setViewName("home");
		return mv;
		} else {
			mv.addObject("titulo", "Getting Tasks Done!");
			mv.addObject("ErrorMessage", "Usuario o contraseña incorrectos");
			mv.setViewName("login");
			return mv;
		}
	}
	
	@RequestMapping(value="/newUser", method = RequestMethod.POST)
	public ModelAndView newUser(@RequestParam String username, @RequestParam String email, @RequestParam String contra, Model model) {
		String errormessage = "Nuevo usuario añadido";
		
		User newUser = new User(username, email, contra);
		insertNewUserDB.insertNewUser(username, email, contra);
		users.add(newUser);
		System.out.println(newUser);
		//userDao.add(newUser);
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		mv.addObject("ErrorMessage", errormessage);
		mv.setViewName("login");
		return mv;
	}
	
	
	
}
