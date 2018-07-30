package com.jay.springdao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.jay.intervieweeRepository.IntervieweeRepository;
import com.jay.tabledomin.Interviewees;

@Service
public class SpringDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private IntervieweeRepository repo;
	
	 public List<Interviewees> findAllEmployee(){
	        return entityManager.createQuery("select * from INTERVIEWEES", Interviewees.class).getResultList();
	    }
	 
	 // to save an interviewee
	 public Interviewees save(Interviewees interviewee) {
		 return repo.save(interviewee);
	 }
	 
	 // search all interviewees
	 public List<Interviewees> findAll() {
		 return repo.findAll();
	 }
	 
	 //get an employee by id
	 public Optional<Interviewees> findOne(Long intId) {
		 return repo.findById(intId);
	 }
	 
}
