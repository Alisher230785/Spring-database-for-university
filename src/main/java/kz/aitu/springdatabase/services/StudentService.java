package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.Student;
import kz.aitu.springdatabase.repositories.StudentRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.StudentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    private final StudentRepositoryInterface repo;

    public StudentService(StudentRepositoryInterface repo) {
        this.repo = repo;
    }


    @Override
    public List<Student> getAll() {
        return repo.findAll();
    }

    @Override
    public Student getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student create(Student student) {
        return repo.save(student);
    }

    public List<Student> getByLastName(String surname) {
        return repo.findBySurname(surname);
    }

    public List<Student> getByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Student> getAllByGpa() {
        return repo.findAllByOrderByGpaDesc();
    }

    @Override
    public List<Student> getAllByCourse(int course) {
        return repo.findAllByCourse(course);
    }
}