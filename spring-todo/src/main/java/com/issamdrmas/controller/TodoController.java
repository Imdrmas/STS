package com.issamdrmas.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.issamdrmas.model.Todo;
import com.issamdrmas.service.ITodoService;


@Controller
public class TodoController {
	@Autowired
	ITodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap modelMap) {
		String name = getLoggedInUSerName(modelMap);
		modelMap.put("todos", todoService.getTodosByUSer(name));
		return "list-todos";
	}
	
	private String getLoggedInUSerName(ModelMap modelMap) {
		Object pronipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (pronipal instanceof UserDetails) {
			return ((UserDetails) pronipal).getUsername();
		}
		return pronipal.toString();
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap modelMap) {
		modelMap.addAttribute("todo", new Todo());
		return "todo";
	}
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		todoService.deleteTodo(id);
		return "redirect:/todo-todos";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPAge(@RequestParam long id, ModelMap modelMap) {
		Todo todo = todoService.getTodoById(id).get();
		modelMap.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setName(getLoggedInUSerName(modelMap));
		todoService.updateTodo(todo);
		return "redirect:/list-todos";
	}
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}
		todo.setName(getLoggedInUSerName(modelMap));
		todoService.savaTodo(todo);
		return "redirect:/list-todos";
	}

}
