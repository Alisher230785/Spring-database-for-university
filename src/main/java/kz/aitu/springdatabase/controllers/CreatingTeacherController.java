package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.CreatingTeacher;
import kz.aitu.springdatabase.services.interfaces.CreatingTeacherServiceInterface;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping({"/update/{teacher_id}","/update/{teacher_id}/"})
    public CreatingTeacher updateTeacher(@PathVariable("teacher_id") int id, @RequestBody CreatingTeacher teacher) {
        return service.updateTeacher(id,teacher);
    }

    @DeleteMapping({"/delete/{teacher_id}","/delete/{teacher_id}/"})
    public void deleteTeacher(@PathVariable("teacher_id") int id) {
        service.deleteTeacherById(id);
    }
}
