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


}
