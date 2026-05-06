package spring_boot_and_java_erudio.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import spring_boot_and_java_erudio.controllers.BookController;
import spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import spring_boot_and_java_erudio.exceptions.RequiredObjectIsNullException;
import spring_boot_and_java_erudio.exceptions.ResourceNotFoundException;
import spring_boot_and_java_erudio.model.Book;
import spring_boot_and_java_erudio.repository.BookRepository;
import static spring_boot_and_java_erudio.mapper.ObjectMapper.parseObject;
import static spring_boot_and_java_erudio.mapper.ObjectMapper.parseListObjects;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

@Service
public class BookService {

    // POST, GET by ID, GET all, UPDATE, DELETE

    private final BookRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookDTO> findAll(){
        logger.info("Getting a List of Books.");

        List<BookDTO> bookDTOS = parseListObjects(repository.findAll(), BookDTO.class);
        bookDTOS.forEach(
                book -> addHateoasLinks(book)
        );

        return bookDTOS;
    }

    public BookDTO findById(Long id){
        logger.info("Getting a Book by ID");

        Book entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not Found!")
        );

        BookDTO bookDTO = parseObject(entity, BookDTO.class);

        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public BookDTO create(BookDTO book){
        if (book == null) throw new RequiredObjectIsNullException();

        logger.info("Creating a Book!");

        Book entity = parseObject(book, Book.class);
        BookDTO bookDTO = parseObject(repository.save(entity), BookDTO.class);

        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public BookDTO update(BookDTO book){
        if (book == null) throw new RequiredObjectIsNullException();

        logger.info("Updating a Book!");

        Book entity = repository.findById(book.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not Found!")
        );

        entity.setAuthor(book.getAuthor());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());
        entity.setLaunchDate(book.getLaunchDate());


        BookDTO bookDTO = parseObject(repository.save(entity), BookDTO.class);

        addHateoasLinks(bookDTO);

        return bookDTO;
    }

    public void delete(Long id){
        logger.info("Deleting a Book!");

        Book entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource Not Found!")
        );


        repository.delete(entity);
    }

    private void addHateoasLinks(BookDTO dto){
        dto.add(linkTo(methodOn(BookController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BookController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BookController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BookController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
