package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.CreatingTeacher;
import kz.aitu.springdatabase.repositories.CreatingTeacherRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.CreatingTeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CreatingTeacherService implements CreatingTeacherServiceInterface {
    private final CreatingTeacherRepositoryInterface repo;
    public CreatingTeacherService(CreatingTeacherRepositoryInterface repo) {
        this.repo = repo;
    }

    public CreatingTeacher createTeacher(CreatingTeacher teacher) {
        return repo.save(teacher);
    }

    @Override
    public CreatingTeacher updateTeacher(int id, CreatingTeacher teacher) {
        CreatingTeacher updatedTeacher = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        updatedTeacher.setAge(teacher.getAge());
        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setSurname(teacher.getSurname());
        updatedTeacher.setSubject(teacher.getSubject());

        return repo.save(updatedTeacher);
    }

    @Override
    public void deleteTeacherById(int id) {
        repo.deleteById(id);
    }
}
