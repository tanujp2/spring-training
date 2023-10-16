package live.tanujdevops.rest.controller;

import jakarta.annotation.PostConstruct;
import live.tanujdevops.rest.entity.Student;
import live.tanujdevops.rest.exception.StudentErrorResponse;
import live.tanujdevops.rest.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Ramesh", "Pandey"));
        students.add(new Student("Parmesh", "Khatri"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
//    if the path variable name and the method param name are same then there is no need to
//    specify name attribute in the annotation
    public Student getStudent(@PathVariable(name = "id") int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException(String.format("Student not found, id = %d", studentId));
        }

        return students.get(studentId);
    }

    @ExceptionHandler
//    these handlers are specific to the controller
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe) {
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), snfe.getMessage(), new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
//    any other exception is due to bad request such as a request
//    to get student by passing a string argument as an id
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
