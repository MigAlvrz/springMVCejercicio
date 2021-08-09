package com.capgemini.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.model.Task;
import com.capgemini.persistance.ListTasksDB;
import com.capgemini.persistance.addTaskDB;

@Controller
@RequestMapping(value ="/tasks")
public class TasksController {

	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView tasks(Model model) {
		ListTasksDB listTasks = new ListTasksDB();
		
		List<Task> tasksInbox = listTasks.listInbox(2);
		model.addAttribute("tasksInbox", tasksInbox);

		List<Task> tasksHoy = listTasks.listHoy(2);
		model.addAttribute("tasksHoy", tasksHoy);

		List<Task> tasksSemana = listTasks.listSemana(2);
		model.addAttribute("tasksSemana", tasksSemana);

		List<Task> tasksCategoria = listTasks.listTareasCategorias(2, "categoria1");
		model.addAttribute("tasksCategoria", tasksCategoria);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("tasks");
		return mv;
	}
	

	

}
