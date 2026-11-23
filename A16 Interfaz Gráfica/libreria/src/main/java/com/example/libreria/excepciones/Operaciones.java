package com.example.libreria.excepciones;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Operaciones {

    @GetMapping("/divide")
    public String divide(@RequestParam String numero) {
        int valor = Integer.parseInt(numero);
        int resultado = 20 / valor;
        return "Resultado: " + resultado;
    }

    @GetMapping("/valor-nulo")
    public String valorNulo() {
        String texto = null;
        return "Longitud: " + texto.length();
    }
}
