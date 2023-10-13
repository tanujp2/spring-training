package live.tanujdevops.jpacmd.dao;

import live.tanujdevops.jpacmd.entity.Student;

//DAO: Data Access Object is a common design pattern
//the application does not directly deal with the database calls rather
//interfaces with DAO object to complete its operations
public interface StudentDAO {
	void save(Student student);

	Student findById(int id);
}