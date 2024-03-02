package kz.aitu.springdatabase.controllers;

import kz.aitu.springdatabase.models.Student;
import kz.aitu.springdatabase.services.interfaces.StudentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private final StudentServiceInterface service;

    public StudentController(StudentServiceInterface service) {
        this.service = service;
    }

    @GetMapping({"", "/"})
    public List<Student> getAllStudents(){
        return service.getAll();
    }

    @GetMapping({"/{student_id}","/{student_id}/"})
    public ResponseEntity<Student> getStudentById(@PathVariable("student_id") int id) {
        Student student = service.getById(id);
        if(student == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 not found
        return new ResponseEntity<>(student,HttpStatus.OK); // 200 OK
    }

    @PostMapping({"/create","/create/"})
    public ResponseEntity<Student> CreateStudent(@RequestBody Student student) {
        Student createdStudent = service.create(student);
        if(createdStudent == null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500 internal server error
        return new ResponseEntity<>(student,HttpStatus.CREATED); // 201 created
    }

    @GetMapping({"/surname/{student_surname}","/surname/{student_surname}/"})
    public List<Student> getAllStudentsBySurname(@PathVariable("student_surname") String surname){
        return service.getByLastName(surname);
    }

    @GetMapping({"/name/{student_name}","/name/{student_name}/"})
    public List<Student> getAllStudentsByName(@PathVariable("student_name") String name){
        return service.getByName(name);
    }

    @GetMapping({"/gpa","/gpa/"})
    public List<Student> getAllStudentsByGPA() {
        return service.getAllByGpa();
    }

    @GetMapping({"/course/{student_course}","/course/{student_course}/"})
    public List<Student> getAllStudentsByCourse(@PathVariable("student_course") int course) {
        return service.getAllByCourse(course);
    }

    @PutMapping({"/update/{student_id}","/update/{student_id}/"})
    public Student updateStudent(@PathVariable("student_id") int id, @RequestBody Student student ) {
        return service.updateEntity(id,student);
    }

    @DeleteMapping({"/delete/{student_id}","/delete/{student_id}/"})
    public void deleteStudent(@PathVariable("student_id") int id ) {
        service.deleteStudent(id);
    }

    @GetMapping({"/stipendholedrs","/stipendholders/"})
    public List<Student> stipendHolders() {
        return service.stipendHolder(); // get students with GPA > 2.67
    }

    @GetMapping({"/analyse/{student_id}","/analyse/{student_id}/"})
    public String analyseStudentByGPA(@PathVariable("student_id") int id) {
        return service.analyseStudent(id);
    }
}
