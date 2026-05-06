package spring_boot_and_java_erudio.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_boot_and_java_erudio.controllers.docs.BookControllerDocs;
import spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import spring_boot_and_java_erudio.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
public class BookController implements BookControllerDocs {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
                           MediaType.APPLICATION_XML_VALUE,
                           MediaType.APPLICATION_YAML_VALUE})
    @Override
    public List<BookDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
                                             MediaType.APPLICATION_XML_VALUE,
                                             MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BookDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_YAML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_YAML_VALUE})
    public BookDTO create(@RequestBody BookDTO dto) {
        return service.create(dto);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_YAML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE,
                            MediaType.APPLICATION_YAML_VALUE})
    @Override
    public BookDTO update(@RequestBody BookDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
