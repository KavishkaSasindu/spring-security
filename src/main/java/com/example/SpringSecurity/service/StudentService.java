package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.StudentModel;
import com.example.SpringSecurity.repo.StudentRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@NoArgsConstructor
public class StudentService {

    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public StudentModel createStudent(StudentModel studentModel) {
        return studentRepo.save(studentModel);
    }

    public List<StudentModel> getAllStudent() {
        return studentRepo.findAll();
    }
}
