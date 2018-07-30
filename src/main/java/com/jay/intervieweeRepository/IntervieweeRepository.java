package com.jay.intervieweeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jay.tabledomin.Interviewees;

public interface IntervieweeRepository extends JpaRepository<Interviewees, Long> {

}
