package live.tanujdevops.jpacmd.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import live.tanujdevops.jpacmd.entity.Student;

@Repository
//specialized @Component annotation that will provide some features related to data access to the
//application, such as translating checked exception to unchecked execption
public class StudentDAOImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
//	persisting or saving operations are run under a transaction
//	@Transactional is spring annotation, that will automatically start the transaction and end it
	public void save(Student student) {
		entityManager.persist(student);
//		persist() saves the object in the database, and updates the object with any generated
//		details from the database, such as id
	}

	@Override
//	@Transactional is not needed because we are not creating or modifying a record
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
//		JPA Query Language (JPQL) works with Entity name and Field names of the entity
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public List<Student> findByLastName(String lastName) {
//		JPQL names parameters are prefixed with :
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:value", Student.class);
//		set the value of the parameter
		query.setParameter("value", lastName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void delete(Student student) {
//		a detached object cannot be deleted
//		hence make the object managed by the persistence context
		Student managed;
		if (entityManager.contains(student)) {
			entityManager.remove(student);
			return;
		}

		managed = entityManager.merge(student);
		entityManager.remove(managed);
	}

}
