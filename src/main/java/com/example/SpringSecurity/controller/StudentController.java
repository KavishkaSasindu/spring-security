package com.example.SpringSecurity.controller;


import com.example.SpringSecurity.model.StudentModel;
import com.example.SpringSecurity.service.StudentService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveUser(@RequestBody StudentModel student) {
        if(student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid data");
        }

        return ResponseEntity.status(HttpStatus.OK).body(studentService.createStudent(student));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getALlStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }
}
