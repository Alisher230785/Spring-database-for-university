package kz.aitu.springdatabase.repositories;

import kz.aitu.springdatabase.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepositoryInterface extends JpaRepository<Student, Integer> {
    List<Student> findBySurname(String surname);
    List<Student> findByName(String name);
    List<Student> findAllByOrderByGpaDesc();
    List<Student> findAllByCourse(int course);
    List<Student> findAllByGpaAfter(double gpa);
    @Query("SELECT COUNT(s) + 1 FROM Student s WHERE s.gpa > :gpa OR (s.gpa = :gpa AND s.id < :studentId)")
    int findPositionByGPA(@Param("gpa") double gpa, @Param("studentId") int studentId);
}