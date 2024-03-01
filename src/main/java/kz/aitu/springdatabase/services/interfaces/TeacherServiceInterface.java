package kz.aitu.springdatabase.services.interfaces;

import kz.aitu.springdatabase.models.Teacher;

public interface TeacherServiceInterface {
    Teacher createTeacher(Teacher teacher);
    Teacher updateTeacher(int id, Teacher teacher);
    void deleteTeacherById(int id);
}
