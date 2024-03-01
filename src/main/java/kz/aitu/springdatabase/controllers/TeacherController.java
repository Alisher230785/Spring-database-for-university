package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.Teacher;
import kz.aitu.springdatabase.services.interfaces.TeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teachers")
public class TeacherController {
    private final TeacherServiceInterface service;
    public TeacherController(TeacherServiceInterface service) {
        this.service = service;
    }

    @PostMapping({"/create","/create/"})
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = service.createTeacher(teacher);
        if(createdTeacher == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 internal server error
        return new ResponseEntity<>(createdTeacher,HttpStatus.CREATED); // 201 created
    }

    @PutMapping({"/update/{teacher_id}","/update/{teacher_id}/"})
    public Teacher updateTeacher(@PathVariable("teacher_id") int id, @RequestBody Teacher teacher) {
        return service.updateTeacher(id,teacher);
    }

    @DeleteMapping({"/delete/{teacher_id}","/delete/{teacher_id}/"})
    public void deleteTeacher(@PathVariable("teacher_id") int id) {
        service.deleteTeacherById(id);
    }
}
