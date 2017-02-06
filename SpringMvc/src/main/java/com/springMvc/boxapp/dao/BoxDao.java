package com.springMvc.boxapp.dao;

import java.util.List;

import com.springMvc.boxapp.model.Box;

public interface BoxDao {
	public void addBook(Box box);
	public List<Box> listBoxes();
}
