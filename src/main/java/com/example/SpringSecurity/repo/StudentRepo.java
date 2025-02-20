package com.example.SpringSecurity.repo;

import com.example.SpringSecurity.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Long> {
}
