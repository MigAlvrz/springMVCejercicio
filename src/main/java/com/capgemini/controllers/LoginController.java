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

import com.capgemini.model.Task;
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
		
		
		long userId = activeUser.getId();
		
		ListTasksDB listTasks = new ListTasksDB();
		
		List<Task> tasksInbox = listTasks.listInbox(userId);
		model.addAttribute("tasksInbox", tasksInbox);

		List<Task> tasksHoy = listTasks.listHoy(userId);
		model.addAttribute("tasksHoy", tasksHoy);

		List<Task> tasksSemana = listTasks.listSemana(userId);
		model.addAttribute("tasksSemana", tasksSemana);

		List<Task> tasksCategoria = listTasks.listTareasCategorias(userId, "categoria1");
		model.addAttribute("tasksCategoria", tasksCategoria);
		
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
		String errormessage = "";
		User newUser = new User(username, email, contra);
		insertNewUserDB.insertNewUser(username, email, contra);
		if(!containsName(users, username)) {
		insertNewUserDB.insertNewUser(username, email, contra);
		users.add(newUser);
		errormessage = "Nuevo usuario añadido";
		} else {
		errormessage = "Nombre de usuario no disponible";
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Getting Tasks Done!");
		mv.addObject("ErrorMessage", errormessage);
		mv.setViewName("login");
		return mv;
		
	}
	
	private boolean containsName(final ArrayList<User> users, String newName) {
		return users.stream().anyMatch(user -> user.getLogin().equals(newName));
	}
	
	
	@RequestMapping(value="/newTask", method = RequestMethod.POST)
	public ModelAndView newTask(@RequestParam String task, @RequestParam String user, @RequestParam String contra) {
		
		User activeUser=null;
		
		ArrayList<User> users = listUsersDB.listUsers();
		
		ModelAndView mv = new ModelAndView();
		for (User user2 : users) {
			System.out.println(user2.getLogin()+" "+user2.getPassword());
			if(user2.getLogin().equals(user)&&user2.getPassword().equals(contra)){
				activeUser = user2;
				UserBus.setUser(user2);
				System.out.println(activeUser.getLogin());
			}
		}
		
		
		ListTasksDB listTasks = new ListTasksDB();
		
		List<Task> tasksInbox = listTasks.listInbox(activeUser.getId());
		mv.addObject("tasksInbox", tasksInbox);

		List<Task> tasksHoy = listTasks.listHoy(activeUser.getId());
		mv.addObject("tasksHoy", tasksHoy);

		List<Task> tasksSemana = listTasks.listSemana(activeUser.getId());
		mv.addObject("tasksSemana", tasksSemana);

		List<Task> tasksCategoria = listTasks.listTareasCategorias(activeUser.getId(), "categoria1");
		mv.addObject("tasksCategoria", tasksCategoria);
		mv.addObject("activeUser", activeUser);
		
		addTaskDB addTask= new addTaskDB();
		
		addTask.addTask(task, 2, activeUser.getId());
		
		mv.setViewName("home");
		return mv;
		
	}
	
	
	
}
