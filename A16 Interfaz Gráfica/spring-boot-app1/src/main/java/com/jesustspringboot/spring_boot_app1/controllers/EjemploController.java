package com.jesustspringboot.spring_boot_app1.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.jesustspringboot.spring_boot_app1.models.Empleados;

@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String info(Model model) {
        Empleados empleado1 = new Empleados("Juan", "Rodriguez", null, "Gerente", 35, 123456789, 1);
        model.addAttribute("titulo", "Servidor en línea");
        model.addAttribute("servidor", "InformaticConfig");
        model.addAttribute("ip", "192.168.1.1");
        model.addAttribute("empleado", empleado1);
        return "detalles_info";
    }

    @ModelAttribute("empleados")
    public List<Empleados> listaEmpleados() {
        return Arrays.asList(
            new Empleados("Maria", "Perez", "Calle 2 No. 10", "Secretaria", 24, 551234567, 2),
            new Empleados("Carlos", "Lopez", "Av. Central 45", "Analista", 29, 559876543, 3),
            new Empleados("Ana", "Martinez", "Calle 5 No. 8", "Desarrolladora", 27, 554567890, 4)
        );
    }
}
