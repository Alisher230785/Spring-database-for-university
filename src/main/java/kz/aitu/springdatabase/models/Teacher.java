package kz.aitu.springdatabase.models;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacher_id;
    private String name;
    private String surname;
    private int age;
    private String subject;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private List<Student> students;
}