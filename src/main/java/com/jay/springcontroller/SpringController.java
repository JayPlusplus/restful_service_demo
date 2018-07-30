package com.jay.springcontroller;

import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.commondto.IntervieweeDto;
import com.jay.springdao.SpringDao;
import com.jay.springservice.SpringService;
import com.jay.tabledomin.Interviewees;

@RestController
@RequestMapping("/interviewcontroller")
public class SpringController {
	
	@Autowired
	private SpringService restService;
	
	@Autowired
	private SpringDao restDao;
	
	//get all interviewees from hashtable
	@RequestMapping("/getall")
	public Hashtable<String, IntervieweeDto> getAllFromHashTable() {
		return restService.getAllFromHashtable();
	}
	
	//get interviewee by id from hashtable
	@RequestMapping("{id}")
	public IntervieweeDto getPersonByIdFromHashTable(@PathVariable("id") String id) {
		return restService.getPersonByIdFromHashtable(id);
	}
	
	// to save an interviewee into DB
	@PostMapping("/saveinterviewee")
	public Interviewees createEmployee(@Valid @RequestBody Interviewees person) {
		return restDao.save(person);
	}

	// get all interviewees from DB
	@GetMapping("/interviewees")
	public List<Interviewees> getAllInterviewees() {
		return restDao.findAll();
	}
	
	//get interviewee by id from DB
	@GetMapping("/interviewees/{id}")
	public ResponseEntity<Optional<Interviewees>> getIntervieweeById(@PathVariable(value="id") Long id) {
		
		Optional<Interviewees> interviewee = restDao.findOne(id);
		
		if(interviewee == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(interviewee);
	}
	
}
