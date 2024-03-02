To run the programm, just execute SpringDatabaseApplication class by the button "run" or with conbination "shift" + F10

StudentController class:
• Responsible for managing requests related to students: initialization of controller, returning a list of students, getting by ID, name, surname, GPA or course, creating new student, updating and deleting a student.

Student class:
• Represents students in a spring application.

StudentRepositoryInterface:
• Used to extend JpaRepository<Student, Integer> of Spring data jpa, contains methods of student in a spring application. 

StudentService class:
• Implements StudentServiceInterface, providing the capability of using students methods in spring application. 

SpringDatabaseApplication:
• Annotates the application.
• application.properties
this file is intended to store data for connecting to the database, as well as other related data.

Create Teacher:
• Description: Creates a new teacher with the provided details.
• Request Body: JSON object representing the teacher entity.

Update Teacher:
• Description: Updates the details of an existing teacher specified by teacher_id.

Delete Teacher:
• Description: Deletes the teacher with the specified teacher_id.

And when teachers are removed, their students are also removed
