package live.tanujdevops.rest.controller;

import jakarta.annotation.PostConstruct;
import live.tanujdevops.rest.entity.Student;
import live.tanujdevops.rest.exception.StudentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
