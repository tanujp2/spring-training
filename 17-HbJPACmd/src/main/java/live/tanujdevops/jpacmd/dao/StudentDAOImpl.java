package live.tanujdevops.jpacmd.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
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
	}

}
