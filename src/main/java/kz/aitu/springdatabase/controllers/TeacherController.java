package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.Teacher;
import kz.aitu.springdatabase.services.interfaces.TeacherServiceInterface;
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

}

