package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.CreatingTeacher;
import kz.aitu.springdatabase.repositories.CreatingTeacherRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.CreatingTeacherServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class CreatingTeacherService implements CreatingTeacherServiceInterface {
    private final CreatingTeacherRepositoryInterface repo;
    public CreatingTeacherService(CreatingTeacherRepositoryInterface repo) {
        this.repo = repo;
    }

    public CreatingTeacher createTeacher(CreatingTeacher teacher) {
        return repo.save(teacher);
    }
}
