package spring_boot_and_java_erudio.unittests.mapper.mocks;

import spring_boot_and_java_erudio.data.dto.v1.BookDTO;
import spring_boot_and_java_erudio.data.dto.v1.PersonDTO;
import spring_boot_and_java_erudio.model.Book;
import spring_boot_and_java_erudio.model.Person;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class MockBook {


    public Book mockEntity() {
        return mockEntity(0);
    }

    public BookDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Book> mockEntityList() {
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }

    public List<BookDTO> mockDTOList() {
        List<BookDTO> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }

    public Book mockEntity(Integer number) {
        Book book = new Book();
        book.setAuthor("Author Test" + number);
        book.setTitle("Title Test" + number);
        book.setPrice(BigDecimal.valueOf(number));
        book.setId(number.longValue());
        book.setLaunchDate(LocalDateTime.of(2026, 4, 20, 4, 30, 20));
        return book;
    }

    public BookDTO mockDTO(Integer number) {
        BookDTO book = new BookDTO();
        book.setAuthor("Author Test" + number);
        book.setTitle("Title Test" + number);
        book.setPrice(BigDecimal.valueOf(number));
        book.setId(number.longValue());
        book.setLaunchDate(LocalDateTime.of(2026, 4, 20, 4, 30, 20));
        return book;
    }

}