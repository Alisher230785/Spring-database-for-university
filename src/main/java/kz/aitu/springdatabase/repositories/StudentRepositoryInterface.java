package kz.aitu.springdatabase.repositories;

import kz.aitu.springdatabase.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {
    List<Student> findBySurname(String surname);
    List<Student> findByName(String name);
}