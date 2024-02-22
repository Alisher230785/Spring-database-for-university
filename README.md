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
