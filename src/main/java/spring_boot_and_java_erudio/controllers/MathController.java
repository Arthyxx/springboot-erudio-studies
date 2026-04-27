package spring_boot_and_java_erudio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_boot_and_java_erudio.service.MathService;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService service;

    public MathController(MathService service) {
        this.service = service;
    }


    @GetMapping("/sum/{num1}/{num2}")
    public Double somar(@PathVariable String num1, @PathVariable String num2) {
        return service.somar(num1, num2);
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double subtrair(@PathVariable String num1, @PathVariable String num2){
        return service.subtrair(num1, num2);
    }

    @GetMapping("/multi/{num1}/{num2}")
    public Double multiplicar(@PathVariable String num1, @PathVariable String num2){
        return service.multiplicar(num1, num2);
    }

    @GetMapping("/div/{num1}/{num2}")
    public Double dividir(@PathVariable String num1, @PathVariable String num2){
        return service.dividir(num1, num2);
    }

    @GetMapping("/med/{num1}/{num2}/{num3}")
    public Double media(@PathVariable String num1, @PathVariable String num2, @PathVariable String num3){
        return service.media(num1, num2, num3);
    }

    @GetMapping("/raiz/{num1}")
    public Double raiz(@PathVariable String num1){
        return service.raiz(num1);
    }
}
