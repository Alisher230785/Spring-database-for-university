package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.ShowingTeacher;
import kz.aitu.springdatabase.services.interfaces.ShowingTeacherServiceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class ShowingTeacherController {
    private final ShowingTeacherServiceInterface service;

    public ShowingTeacherController(ShowingTeacherServiceInterface service) {
        this.service = service;
    }

    @GetMapping({"","/"})
    public List<ShowingTeacher> getAllTeachers() {
        return service.getAllTeachers();
    }

}

