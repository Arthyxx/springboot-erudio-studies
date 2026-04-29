package spring_boot_and_java_erudio.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import spring_boot_and_java_erudio.services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping(value = "/v1/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
                                                MediaType.APPLICATION_XML_VALUE,
                                                MediaType.APPLICATION_YAML_VALUE})
    public PersonDTO findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE,
                                           MediaType.APPLICATION_XML_VALUE,
                                           MediaType.APPLICATION_YAML_VALUE})
    public List<PersonDTO> findAll(){
        return service.findAll();
    }

    @PostMapping(value = "/v1", consumes = {MediaType.APPLICATION_JSON_VALUE,
                                            MediaType.APPLICATION_XML_VALUE,
                                            MediaType.APPLICATION_YAML_VALUE},
                                produces = {MediaType.APPLICATION_JSON_VALUE,
                                            MediaType.APPLICATION_XML_VALUE,
                                            MediaType.APPLICATION_YAML_VALUE})
    public PersonDTO create(@RequestBody PersonDTO person){
        return service.create(person);
    }

    @PutMapping(value = "/v1", consumes = {MediaType.APPLICATION_JSON_VALUE,
                                           MediaType.APPLICATION_XML_VALUE,
                                           MediaType.APPLICATION_YAML_VALUE},
                               produces = {MediaType.APPLICATION_JSON_VALUE,
                                           MediaType.APPLICATION_XML_VALUE,
                                           MediaType.APPLICATION_YAML_VALUE})
    public PersonDTO update(@RequestBody PersonDTO person){
        return service.update(person);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
