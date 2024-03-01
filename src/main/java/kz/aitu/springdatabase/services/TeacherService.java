package kz.aitu.springdatabase.services;

import kz.aitu.springdatabase.models.Teacher;
import kz.aitu.springdatabase.repositories.TeacherRepositoryInterface;
import kz.aitu.springdatabase.services.interfaces.TeacherServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TeacherService implements TeacherServiceInterface {
    private final TeacherRepositoryInterface repo;
    public TeacherService(TeacherRepositoryInterface repo) {
        this.repo = repo;
    }

    public Teacher createTeacher(Teacher teacher) {
        return repo.save(teacher);
    }

    @Override
    public Teacher updateTeacher(int id, Teacher teacher) {
        Teacher updatedTeacher = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

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
