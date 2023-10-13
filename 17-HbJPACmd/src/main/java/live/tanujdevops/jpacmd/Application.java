package live.tanujdevops.jpacmd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import live.tanujdevops.jpacmd.dao.StudentDAO;
import live.tanujdevops.jpacmd.entity.Student;

@SpringBootApplication
public class Application {

	private StudentDAO studentDAO;

	@Autowired
	public Application(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return runner -> {
			readAllStudents(studentDAO);
		};
	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> savedStudents = studentDAO.findAll();
		savedStudents.forEach(student -> System.out.println(student));
	}

	private void readStudent(StudentDAO studentDAO) {
		int id = 2;
		System.out.println("Retrieving student with id: " + id);
		Student savedStudent = studentDAO.findById(1);
		System.out.println(savedStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating students...");
		Student jess = new Student("Jess", "Rouff", "jrouff1@clickbank.net");
		Student mendie = new Student("Mendie", "Demangeon", "mdemangeon2@storify.com");
		Student anabal = new Student("Anabal", "Gunby", "agunby3@weebly.com");
		Student minor = new Student("Minor", "Crosscombe", "mcrosscombe4@wordpress.org");

		System.out.println("Saving students...");
		studentDAO.save(jess);
		studentDAO.save(mendie);
		studentDAO.save(anabal);
		studentDAO.save(minor);

		System.out.println("Updated students' record: ");
		System.out.println(jess);
		System.out.println(mendie);
		System.out.println(anabal);
		System.out.println(minor);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student haven = new Student("Haven", "Pipoworth", "hpipworth0@furl.net");
		System.out.println("Saving the student...");
		studentDAO.save(haven);
		System.out.println("Saved student's generated id: " + haven.getId());
	}

}
