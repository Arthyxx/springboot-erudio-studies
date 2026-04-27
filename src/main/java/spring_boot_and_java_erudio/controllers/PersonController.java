package spring_boot_and_java_erudio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring_boot_and_java_erudio.model.Person;
import spring_boot_and_java_erudio.service.PersonServices;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id){
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
    public void delete(String id){
        service.delete(id);
    }
}
