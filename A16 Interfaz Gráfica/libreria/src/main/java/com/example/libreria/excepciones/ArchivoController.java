package com.example.libreria.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {
    private final FileContent fileContent;

    public ArchivoController(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    @GetMapping("/lectura")
    public ResponseEntity<String> leer(@RequestParam String ruta) {
        try {
            return ResponseEntity.ok(fileContent.lecturaArchivo(ruta));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
