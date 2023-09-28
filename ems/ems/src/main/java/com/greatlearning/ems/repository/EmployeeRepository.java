package com.greatlearning.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.ems.entity.Empolyee;

@Repository
public interface EmployeeRepository extends JpaRepository<Empolyee, String> {

}
