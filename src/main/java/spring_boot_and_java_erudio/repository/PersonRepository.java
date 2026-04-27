package spring_boot_and_java_erudio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_boot_and_java_erudio.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
