package kz.aitu.springdatabase.models;

import jakarta.persistence.*;
import lombok.Data;

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
}