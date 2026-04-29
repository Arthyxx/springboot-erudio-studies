package spring_boot_and_java_erudio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spring_boot_and_java_erudio.controllers.PersonController;
import spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import spring_boot_and_java_erudio.exceptions.RequiredObjectIsNullException;
import spring_boot_and_java_erudio.exceptions.ResourceNotFoundException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static spring_boot_and_java_erudio.mapper.ObjectMapper.parseListObjects;
import static spring_boot_and_java_erudio.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import spring_boot_and_java_erudio.model.Person;
import spring_boot_and_java_erudio.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    private final PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }



    public List<PersonDTO> findAll(){
        logger.info("Finding all People!");

        List<PersonDTO> personDTOS = parseListObjects(repository.findAll(), PersonDTO.class);
        personDTOS.forEach(p -> addHateoasLinks(p));
        return personDTOS;
    }


    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");
        Optional<Person> byId = repository.findById(id);

        if (byId.isEmpty()) throw new ResourceNotFoundException("Person not found!");

        PersonDTO dto = parseObject(byId.get(), PersonDTO.class);
        addHateoasLinks(dto);

        return dto;
    }


    public PersonDTO create(PersonDTO person){

        if (person == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one Person!");

        Person entity = parseObject(person, Person.class);

        PersonDTO dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);

        return dto;
    }

    public PersonDTO update(PersonDTO person){

        if (person == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        PersonDTO dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);

        return dto;
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        repository.delete(entity);
    }

    private void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
