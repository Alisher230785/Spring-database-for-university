package kz.aitu.springdatabase.services.interfaces;

import kz.aitu.springdatabase.models.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAll();
    Student getById(int id);
    Student create(Student student);
    List<Student> getBySurname(String surname);
}
