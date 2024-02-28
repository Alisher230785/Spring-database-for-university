package kz.aitu.springdatabase.repositories;

import kz.aitu.springdatabase.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepositoryInterface extends JpaRepository<Teacher, Integer> {
}
