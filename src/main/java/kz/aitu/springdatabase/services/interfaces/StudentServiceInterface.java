package kz.aitu.springdatabase.services.interfaces;

import kz.aitu.springdatabase.models.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAll(); // return all students
    Student getById(int id); // return student by id
    Student create(Student student); // create new student
    List<Student> getByLastName(String surname); // return students by Surname
    List<Student> getByName(String name); // return students by Name
    List<Student> getAllByGpa(); // return students by Gpa
    List<Student> getAllByCourse(int course); // return student by Course
    Student updateEntity(int id, Student student); // update information about the student by id
    void deleteStudent(int id); // delete student by id
    List<Student> stipendHolder(); // return all students will stipends
    String analyseStudent(int id); // return student's position by gpa
}
