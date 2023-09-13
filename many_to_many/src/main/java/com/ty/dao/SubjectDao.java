package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.Student;
import com.ty.dto.Subject;

public class SubjectDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveSubject(Subject subject) {
		entityTransaction.begin();
		entityManager.persist(subject);
		entityTransaction.commit();
	}

	public Subject update(Subject subject) {
		entityTransaction.begin();
		entityManager.merge(subject);
		entityTransaction.commit();
		return subject;
	}

	public Subject findById(int subject_id) {
		return entityManager.find(Subject.class, subject_id);
	}

	public List<Subject> fecthAll() {
		Query query = entityManager.createQuery("select subject from Subject subject");
		return query.getResultList();

	}

	public void delete(int subject_id) {
		Student subject = entityManager.find(Student.class, subject_id);
		entityTransaction.begin();
		entityManager.remove(subject);
		entityTransaction.commit();
	}
}
