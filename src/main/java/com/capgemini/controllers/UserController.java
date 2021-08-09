package com.capgemini.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.capgemini.model.User;
import com.capgemini.model.UserBus;
import com.capgemini.persistance.DBConnection;
import com.capgemini.persistance.UserDao;
import com.capgemini.persistance.UserDaoImpl;

@Controller
@RequestMapping(value ="/user")
public class UserController {
	
	@Autowired @Qualifier("UserDaoImpl")
	private UserDao userDao;
	
	@RequestMapping(value="", method = RequestMethod.POST)
	public ModelAndView user(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		return mv;
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {		
		System.out.println("volviendo al home");
		User activeUser = UserBus.getUser();
		
		model.addAttribute("activeUser", activeUser);
		return new ModelAndView("redirect:/home/", model);
	}
	
	@RequestMapping(value="/modUser", method = RequestMethod.POST)
	public ModelAndView modUser(Model model, @RequestParam String newName, @RequestParam String newMail, @RequestParam String newContra, @RequestParam String contraConfirm) {
		User user = UserBus.getUser();
		user.setLogin(newName);
		user.setEmail(newMail);
		user.setPassword(newContra);
		System.out.println(user.getLogin());
		System.out.println(user.getEmail());
		UserBus.setUser(user);
		Connection con;
		try {
			con = DBConnection.DBAccess();
			Statement stmt = con.createStatement();
			stmt.executeQuery("UPDATE TUSERS SET email = '"+newMail+"', login='"+newName+"', password='"+String.valueOf(newContra)+"' WHERE ID="+user.getId()+";");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("activeUser", user);
		mv.setViewName("user");
		return mv;
		
	}

}
