package spring_boot_and_java_erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot_and_java_erudio.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
