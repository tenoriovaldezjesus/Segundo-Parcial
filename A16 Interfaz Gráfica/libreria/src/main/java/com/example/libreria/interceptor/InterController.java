package com.example.libreria.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterController {
    @GetMapping("/saludos")
    public String saludos() {
        return "Probando interceptores";
    }
}
