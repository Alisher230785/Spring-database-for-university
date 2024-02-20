package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.Student;
import kz.aitu.springdatabase.services.interfaces.StudentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentServiceInterface service;

    public StudentController(StudentServiceInterface service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public List<Student> getAll(){
        return service.getAll();
    }

    @GetMapping("/{student_id}")
    public ResponseEntity<Student> getById(@PathVariable("student_id") int id) {
        Student student = service.getById(id);
        if(student == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 not found
        return new ResponseEntity<>(student,HttpStatus.OK); // 200 OK
    }

    @PostMapping({"/create","/create/"})
    public ResponseEntity<Student> CreateStudent(@RequestBody Student student) {
        Student createdStudent = service.create(student);
        if(createdStudent == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500
        return new ResponseEntity<>(student,HttpStatus.CREATED); // 201 created
    }

}
