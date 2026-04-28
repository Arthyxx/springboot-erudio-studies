package spring_boot_and_java_erudio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import spring_boot_and_java_erudio.data.dto.v2.PersonDTOV2;
import spring_boot_and_java_erudio.exceptions.ResourceNotFoundException;
import static spring_boot_and_java_erudio.mapper.ObjectMapper.parseListObjects;
import static spring_boot_and_java_erudio.mapper.ObjectMapper.parseObject;

import spring_boot_and_java_erudio.mapper.custom.PersonMapper;
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

    @Autowired
    private PersonMapper converter;


    public List<PersonDTO> findAll(){
        logger.info("Finding all People!");

        return parseListObjects(repository.findAll(), PersonDTO.class);
    }


    public PersonDTO findById(Long id){
        logger.info("Finding one Person!");
        Optional<Person> byId = repository.findById(id);

        if (byId.isEmpty()) throw new ResourceNotFoundException("Person not found!");

        return parseObject(byId.get(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one Person!");

        Person entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person){
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        repository.delete(entity);
    }

    public PersonDTOV2 createV2(PersonDTOV2 person){
        logger.info("Creating one Person V2!");

        Person entity = converter.convertDTOToEntity(person);

        return converter.convertEntityToDTO(repository.save(entity));
    }
}
