package spring_boot_and_java_erudio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot_and_java_erudio.model.Person;
import spring_boot_and_java_erudio.services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
