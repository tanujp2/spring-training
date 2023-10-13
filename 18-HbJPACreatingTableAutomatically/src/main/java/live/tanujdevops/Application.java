package live.tanujdevops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import live.tanujdevops.entity.Student;

@SpringBootApplication
public class Application {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			createStudent();
		};
	}

	private void createStudent() {
		System.out.println("Creating students...");
		Student jess = Student.builder().firstName("Jess").lastName("Rouff").email("jrouff1@clickbank.net").build();
		Student mendie = Student.builder().firstName("Mendie").lastName("Demangeon").email("mdemangeon2@storify.com")
				.build();
		Student anabal = Student.builder().firstName("Anabal").lastName("Gunby").email("agunby3@weebly.com").build();
		Student minor = Student.builder().firstName("Minor").lastName("Crosscombe").email("mcrosscombe4@wordpress.org")
				.build();

		System.out.println("Saving students...");

//		start transaction
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(jess);
		entityManager.persist(mendie);
		entityManager.persist(anabal);
		entityManager.persist(minor);

//		complete transaction
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("Updated students' record: ");
		System.out.println(jess);
		System.out.println(mendie);
		System.out.println(anabal);
		System.out.println(minor);

	}

}
