package com.springMvc.boxapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springMvc.boxapp.dao.BoxDao;
import com.springMvc.boxapp.model.Box;

@Controller
public class HomeController {
	@Autowired
	private BoxDao boxDao;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
		
	}
	@RequestMapping(value="/addbox",method = RequestMethod.POST)
	public ModelAndView addBox(@ModelAttribute Box box){
		boxDao.addBook(box);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/listboxes")
	public ModelAndView listBoxes(ModelAndView model) throws IOException{
	    List<Box> listBoxes =boxDao.listBoxes();
	    model.addObject("listBoxes", listBoxes);
	    model.setViewName("home");
	    return model;
	}
	@RequestMapping(value = "/deletebox", method = RequestMethod.GET)
	public ModelAndView deleteBox(HttpServletRequest request) {
	    int boxId = Integer.parseInt(request.getParameter("id"));
	    boxDao.deleteBox(boxId);
	    return new ModelAndView("redirect:/home.jsp");
	}
}
