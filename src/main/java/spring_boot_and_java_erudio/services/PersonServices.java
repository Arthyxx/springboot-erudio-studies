package spring_boot_and_java_erudio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_boot_and_java_erudio.exceptions.ResourceNotFoundException;
import spring_boot_and_java_erudio.model.Person;
import spring_boot_and_java_erudio.repository.PersonRepository;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository repository;


    public List<Person> findAll(){
        logger.info("Finding all People!");

        return repository.findAll();
    }


    public Person findById(Long id){
        logger.info("Finding one Person!");
        Optional<Person> byId = repository.findById(id);

        if (byId.isEmpty()) throw new ResourceNotFoundException("Person not found!");

        return byId.get();
    }

    public Person create(Person person){
        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one Person!");

        Person entity = findById(person.getId());

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id){
        logger.info("Deleting one Person!");

        Person person = findById(id);
        repository.delete(person);
    }
}
