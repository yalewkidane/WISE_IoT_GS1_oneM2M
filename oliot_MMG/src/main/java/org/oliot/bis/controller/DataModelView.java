package org.oliot.bis.controller;


import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DataModelView {
	
	// @ResponseBody
	@RequestMapping("/")
	public String index() {
		return "newfile";
	}

		
	@ResponseBody
	@RequestMapping("dataModels")
	public String dataModelList() {
		
		return "List of data models";
		
	}
	
	
	@ResponseBody
	@RequestMapping("schemas/BusEstimation.json")
	public JsonNode busEstimation_Schema() throws JsonProcessingException, IOException {
		//String text="{\"name\":\"John\", \"age\":31, \"city\":\"New York\" }";
		ObjectMapper mapper = new ObjectMapper();
	    //JsonNode actualObj = mapper.readTree(text);
	    
	    ClassLoader classLoader = getClass().getClassLoader();
	    
	    
	    String jsonString ="";
	    try {

	    	 jsonString=IOUtils.toString(classLoader.getResourceAsStream("resources/BusEstimation_Schema.json"));

		} catch (IOException e) {

			e.printStackTrace();
			
			return mapper.readTree("[]");

		}
	    JsonNode actualObj = mapper.readTree(jsonString);
		return actualObj;
	}
	
	@ResponseBody
	@RequestMapping("schemas/BusStop.json")
	public JsonNode BusStop_Schema() throws JsonProcessingException, IOException {
		//String text="{\"name\":\"John\", \"age\":31, \"city\":\"New York\" }";
		ObjectMapper mapper = new ObjectMapper();
	    //JsonNode actualObj = mapper.readTree(text);
	    
	    ClassLoader classLoader = getClass().getClassLoader();
	  
	    String jsonString ="";
	    try {

	    	jsonString=IOUtils.toString(classLoader.getResourceAsStream("resources/BusStop_Schema.json"));

		} catch (IOException e) {

			e.printStackTrace();
			return mapper.readTree("[]");

		}
	    JsonNode actualObj = mapper.readTree(jsonString);
		return actualObj;
	}
	
	@ResponseBody
	@RequestMapping("schemas/BusLine.json")
	public JsonNode BusLine_Schema() throws JsonProcessingException, IOException {
		//String text="{\"name\":\"John\", \"age\":31, \"city\":\"New York\" }";
		ObjectMapper mapper = new ObjectMapper();
	    //JsonNode actualObj = mapper.readTree(text);
	    
	    ClassLoader classLoader = getClass().getClassLoader();
	    String jsonString ="";
	    try {

	    	jsonString=IOUtils.toString(classLoader.getResourceAsStream("resources/BusLine_Schema.json"));

		} catch (IOException e) {

			e.printStackTrace();
			return mapper.readTree("[]");

		}
	    JsonNode actualObj = mapper.readTree(jsonString);
		return actualObj;
	}
	
	@ResponseBody
	@RequestMapping("instances/BusEstimation.json")
	public JsonNode busEstimation_Instance() throws JsonProcessingException, IOException {
		//String text="{\"name\":\"John\", \"age\":31, \"city\":\"New York\" }";
		ObjectMapper mapper = new ObjectMapper();
	    //JsonNode actualObj = mapper.readTree(text);
	    
	    ClassLoader classLoader = getClass().getClassLoader();
	    String jsonString ="";
	    try {

	    	jsonString=IOUtils.toString(classLoader.getResourceAsStream("resources/BusEstimation_Instance.json"));

		} catch (IOException e) {

			e.printStackTrace();
			return mapper.readTree("[]");

		}
	    JsonNode actualObj = mapper.readTree(jsonString);
		return actualObj;
	}
	
	@ResponseBody
	@RequestMapping("instances/BusStop.json")
	public JsonNode BusStop_Instance() throws JsonProcessingException, IOException {
		//String text="{\"name\":\"John\", \"age\":31, \"city\":\"New York\" }";
		ObjectMapper mapper = new ObjectMapper();
	    //JsonNode actualObj = mapper.readTree(text);
	    
	    ClassLoader classLoader = getClass().getClassLoader();
	    String jsonString ="";
	    try {

	    	jsonString=IOUtils.toString(classLoader.getResourceAsStream("resources/BusStop_instance.json"));

		} catch (IOException e) {

			e.printStackTrace();
			return mapper.readTree("[]");

		}
	    JsonNode actualObj = mapper.readTree(jsonString);
		return actualObj;
	}
	
	@ResponseBody
	@RequestMapping("instances/BusLine.json")
	public JsonNode BusLine_Instance() throws JsonProcessingException, IOException {
		//String text="{\"name\":\"John\", \"age\":31, \"city\":\"New York\" }";
		ObjectMapper mapper = new ObjectMapper();
	    //JsonNode actualObj = mapper.readTree(text);
	    
	    ClassLoader classLoader = getClass().getClassLoader();
	    String jsonString ="";
	    try {

	    	jsonString=IOUtils.toString(classLoader.getResourceAsStream("resources/BusLine_instance.json"));

		} catch (IOException e) {

			e.printStackTrace();

		}
	    JsonNode actualObj = mapper.readTree(jsonString);
		return actualObj;
	}

}
