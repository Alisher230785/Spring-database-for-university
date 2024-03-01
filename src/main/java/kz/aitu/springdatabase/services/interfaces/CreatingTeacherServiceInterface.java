package kz.aitu.springdatabase.services.interfaces;

import kz.aitu.springdatabase.models.CreatingTeacher;

public interface CreatingTeacherServiceInterface {
    CreatingTeacher createTeacher(CreatingTeacher teacher);
    CreatingTeacher updateTeacher(int id, CreatingTeacher teacher);
    void deleteTeacherById(int id);
}
