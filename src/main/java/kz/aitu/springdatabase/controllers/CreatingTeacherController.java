package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.CreatingTeacher;
import kz.aitu.springdatabase.services.interfaces.CreatingTeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teachers")
public class CreatingTeacherController {
    private final CreatingTeacherServiceInterface service;
    public CreatingTeacherController(CreatingTeacherServiceInterface service) {
        this.service = service;
    }

    @PostMapping({"/create","/create/"})
    public ResponseEntity<CreatingTeacher> createTeacher(@RequestBody CreatingTeacher teacher) {
        CreatingTeacher createdTeacher = service.createTeacher(teacher);
        if(createdTeacher == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 internal server error
        return new ResponseEntity<>(createdTeacher,HttpStatus.CREATED); // 201 created
    }
}
