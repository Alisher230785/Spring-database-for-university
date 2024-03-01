package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.ShowingTeacher;
import kz.aitu.springdatabase.repositories.ShowingTeacherRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.ShowingTeacherServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingTeacherService implements ShowingTeacherServiceInterface {
    private final ShowingTeacherRepositoryInterface repo;
    public ShowingTeacherService(ShowingTeacherRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<ShowingTeacher> getAllTeachers() {
        return repo.findAll();
    }
}
