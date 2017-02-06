package com.springMvc.boxapp.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.ObjectWriter;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springMvc.boxapp.config.MvcConfiguration;
import com.springMvc.boxapp.dao.BoxDao;
import com.springMvc.boxapp.model.Box;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcConfiguration.class)
@WebAppConfiguration
public class HomeControllerTest {
	
	@InjectMocks
    private HomeController ctrler;
	private MockMvc mockMvc;
	@Mock
	@Autowired
    private BoxDao daoMock;
	 @Before
	    public void setup() {
	        MockitoAnnotations.initMocks(this);
	        this.mockMvc = MockMvcBuilders.standaloneSetup(ctrler).build();
	    }

	@Test
	public void testListBoxes() throws Exception {
		List<Box> boxList=new ArrayList<Box>();
		Box box1= new Box();
		box1.setId(0);
		box1.setName("jitendra");
		box1.setWeight(55);
		box1.setColor("white");
		box1.setCountry("3.14");
		box1.setCost(0);
		Box box2= new Box();
		box2.setId(1);
		box2.setName("avi");
		box2.setWeight(45);
		box2.setColor("brown");
		box2.setCountry("4");
		box2.setCost(0);
		boxList.add(box1);
		boxList.add(box2);
		Mockito.when(daoMock.listBoxes()).thenReturn(boxList);
		this.mockMvc.perform(get("/listboxes"))
					.andExpect(status().isOk())
					.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
					.andExpect(jsonPath("$.id").value(IsNull.nullValue()))
					.andExpect(jsonPath("$[0].name").value("jitendra"))
					.andExpect(jsonPath("$[0].color").value("white"));
	}
	@Test
	public void testAddBox() throws Exception { 
	    String url = "/addbox";
	    Box anObject = new Box();
	    anObject.setName("nikil");
	    anObject.setWeight(50);
	    anObject.setColor("yellow");
	    anObject.setCountry("Sweden");
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	    String json = mapper.writeValueAsString(new Box());
	    mockMvc.perform(post(url)
	    		.contentType(MediaType.APPLICATION_JSON)
	    	       .content(json)
	    	       .accept(MediaType.APPLICATION_JSON))
	    	       .andExpect(status().isOk());
	}

}
