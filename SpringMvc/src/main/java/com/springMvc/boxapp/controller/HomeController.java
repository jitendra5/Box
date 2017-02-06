package com.springMvc.boxapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springMvc.boxapp.dao.BoxDao;
import com.springMvc.boxapp.model.Box;

@RestController

public class HomeController {
	@Autowired
	private BoxDao boxDao;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");	
	}
	
	
	@RequestMapping(value="/addbox",method = RequestMethod.POST,consumes="application/json")
	@ResponseBody public Box addBox(@RequestBody Box box){
		boxDao.addBook(box);
		return box;
	}
	
	@RequestMapping(value="/listboxes", method=RequestMethod.GET)
	public @ResponseBody List<Box> listBoxes() {
	    List<Box> listBoxes =boxDao.listBoxes();
	    return listBoxes;
	}
	
}
