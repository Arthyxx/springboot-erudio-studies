package spring_boot_and_java_erudio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import spring_boot_and_java_erudio.data.dto.v2.PersonDTOV2;
import spring_boot_and_java_erudio.services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    @PutMapping
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/v2")
    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person){
        return service.createV2(person);
    }
}
