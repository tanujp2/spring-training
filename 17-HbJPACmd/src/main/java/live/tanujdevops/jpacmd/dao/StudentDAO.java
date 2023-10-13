package live.tanujdevops.jpacmd.dao;

import java.util.List;

import live.tanujdevops.jpacmd.entity.Student;

//DAO: Data Access Object is a common design pattern
//the application does not directly deal with the database calls rather
//interfaces with DAO object to complete its operations
public interface StudentDAO {
	void save(Student student);

	Student findById(int id);

	List<Student> findAll();

	List<Student> findByLastName(String lastName);

	void update(Student student);

	void delete(Student student);

	int deleteAll();
}