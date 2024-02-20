package kz.aitu.springdatabase.repositories;

import kz.aitu.springdatabase.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {
}