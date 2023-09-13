package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
	}

	public void update(Student student) {
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
	//	return student;
	}

	public Student findById(int student_id) {
		return entityManager.find(Student.class, student_id);
	}

	public List<Student> fecthAll() {
		Query query = entityManager.createQuery("select student from Student student");
		return query.getResultList();

	}

	public void delete(int student_id) {
		Student student = entityManager.find(Student.class, student_id);
		entityTransaction.begin();
		entityManager.remove(student);
		entityTransaction.commit();
	}
}
