package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.Teacher;
import kz.aitu.springdatabase.services.interfaces.TeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {
    private final TeacherServiceInterface service;

    public TeacherController(TeacherServiceInterface service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }
    @PostMapping({"/create","/create/"})
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = service.create(teacher);
        if(createdTeacher == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 internal server error
        return new ResponseEntity<>(teacher,HttpStatus.CREATED); // 201 created

    }
}

