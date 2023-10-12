package live.tanujdevops.jpacmd;

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
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student...");
		Student haven = new Student("Haven", "Pipoworth", "hpipworth0@furl.net");
		System.out.println("Saving the student...");
		studentDAO.save(haven);
		System.out.println("Saved student's generated id: " + haven.getId());
	}

}
