package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.Student;
import kz.aitu.springdatabase.repositories.StudentRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.StudentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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

    @Override
    public Student updateEntity(int id, Student student) {
        Student existingStudent = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // if there's no student with the id, return 404
        // mutating the returned student
        existingStudent.setName(student.getName());
        existingStudent.setSurname(student.getSurname());
        existingStudent.setAge(student.getAge());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setGpa(student.getGpa());

        return repo.save(existingStudent); // set it
    }

    @Override
    public void deleteStudent(int id) {
        repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // if there's no student with the id, return 404
        repo.deleteById(id); // delete the student
    }
}