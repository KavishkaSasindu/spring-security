package com.example.SpringSecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/hello")
    public String getHello(HttpServletRequest request) {
        return "Hello User "+ request.getSession().getId();
    }

    @GetMapping("/about")
    public String about() {
        return "Kavishka Sasindu";
    }
}
