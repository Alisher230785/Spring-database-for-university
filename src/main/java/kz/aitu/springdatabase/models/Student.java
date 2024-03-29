package kz.aitu.springdatabase.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;
    private String name;
    private String surname;
    private int age;
    private int course;
    private double gpa;
    private int teacher_id;
}