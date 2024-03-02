package kz.aitu.springdatabase.services.interfaces;

import kz.aitu.springdatabase.models.Teacher;

public interface TeacherServiceInterface {
    Teacher createTeacher(Teacher teacher); // create new teacher
    Teacher updateTeacher(int id, Teacher teacher); // update teacher by id
    void deleteTeacherById(int id); // delete teacher by id
}
