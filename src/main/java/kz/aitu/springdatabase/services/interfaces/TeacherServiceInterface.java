package kz.aitu.springdatabase.services.interfaces;

import kz.aitu.springdatabase.models.Teacher;

import java.util.List;
public interface TeacherServiceInterface {
    List<Teacher> getAllTeachers();

    Teacher create(Teacher teacher);
}
