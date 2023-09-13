package com.ty.service;

import java.util.ArrayList;
import java.util.List;

import com.ty.dao.StudentDao;
import com.ty.dao.SubjectDao;
import com.ty.dto.Student;
import com.ty.dto.Subject;

public class StudentService {
	SubjectDao subjectDao = new SubjectDao();

	public void saveSubject() {
		Subject subject1 = new Subject();
		subject1.setId(101);
		subject1.setName("java");

		Subject subject2 = new Subject();
		subject2.setId(102);
		subject2.setName("HTML");

		Subject subject3 = new Subject();
		subject3.setId(103);
		subject3.setName("sql");

		List<Subject> subject = new ArrayList();
		subject.add(subject1);
		subject.add(subject2);
		subject.add(subject3);
		for (Subject subject4 : subject) {
			subjectDao.saveSubject(subject4);
		}
		

	}

}
