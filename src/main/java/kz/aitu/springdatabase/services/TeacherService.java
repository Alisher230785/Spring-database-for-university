package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.Teacher;
import kz.aitu.springdatabase.repositories.TeacherRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.TeacherServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements TeacherServiceInterface {
    private final TeacherRepositoryInterface repo;

    public TeacherService(TeacherRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return repo.findAll();
    }

    @Override
    public Teacher create(Teacher teacher) {
        return repo.save(teacher);
    }
}
