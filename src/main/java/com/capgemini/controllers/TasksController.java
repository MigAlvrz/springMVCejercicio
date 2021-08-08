package com.capgemini.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.model.Task;
import com.capgemini.persistance.ListTasksDB;

@Controller
@RequestMapping(value ="/tasks")
public class TasksController {
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView tasks(Model model) {
		System.out.println("test1");
		ListTasksDB listTasks = new ListTasksDB();
		List<Task> tasksInbox = listTasks.listInbox(2);
		model.addAttribute("tasksInbox", tasksInbox);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("tasks");
		return mv;
	}
	
}
