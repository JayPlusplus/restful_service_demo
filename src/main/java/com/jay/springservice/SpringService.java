package com.jay.springservice;

import java.util.Date;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.commondto.IntervieweeDto;


@Service
public class SpringService {
	
	//@Autowired
	//private SpringDao dao;
	
	Hashtable<String, IntervieweeDto> interviewee = new Hashtable<String, IntervieweeDto>();
	
	// redefine constructor
	public SpringService() {
		
		//initialize IntervieweeDto
		IntervieweeDto dto = new IntervieweeDto();
		dto.setId("1");
		dto.setFirstName("Jay");
		dto.setLastName("Wu");
		dto.setDate(new Date());
		//put into hashtable key 1
		interviewee.put("1", dto);
		
		dto = new IntervieweeDto();
		dto.setId("2");
		dto.setFirstName("Joe");
		dto.setLastName("Smith");
		dto.setDate(new Date());
		//put into hashtable key 2
		interviewee.put("2", dto);
		
		dto = new IntervieweeDto();
		dto.setId("3");
		dto.setFirstName("Harry");
		dto.setLastName("Potter");
		dto.setDate(new Date());
		//put into hashtable key 3
		interviewee.put("3", dto);
		
	}
	
 	public IntervieweeDto getInfoFromDB() {
		IntervieweeDto dto = new IntervieweeDto();//dao.getAllInfo();
		//dto = dao.getAllInfo();
		return dto;
	}
	
 	public IntervieweeDto getPersonByIdFromHashtable(String id) {
 		if (interviewee.containsKey(id)) {
 			System.out.println("inside getPersonByiD method");
 			return interviewee.get(id);
 		}
 		else return null;
 		
 	}
 	
 	public Hashtable<String, IntervieweeDto> getAllFromHashtable() {
 		return interviewee;
 	}
}
