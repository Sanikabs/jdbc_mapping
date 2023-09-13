package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ty.dao.StudentDao;
import com.ty.dao.SubjectDao;
import com.ty.dto.Student;
import com.ty.dto.Subject;
import com.ty.service.StudentService;

public class DriverClass {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		SubjectDao subjectDao = new SubjectDao();
		StudentService studentService = new StudentService();

		Scanner sc = new Scanner(System.in);
		System.out.println("welcome");
		System.out.println("1.save subjects");
		System.out.println("2.save details");
		System.out.println("3.adding subjects to existing person");
		System.out.println("4.updatestudent\n 5.findByid\n 6.fecthAll\n 7.delete");
		System.out.println("=======================================");
		System.out.println("8.findsubjectById\n 9.fecthAllSubject");

		int choice = sc.nextInt();
		Student student = new Student();
		switch (choice) {
		case 1:
			studentService.saveSubject();
			System.out.println("sucesfully saved");
			break;
		case 2: {
			List<Subject> list = new ArrayList<Subject>();
			System.out.println("enter student id");
			int id = sc.nextInt();
			System.out.println("enter student name");
			String name = sc.next();
			System.out.println("enetr student email");
			String email = sc.next();
			// Student student = new Student();
			student.setId(id);
			student.setName(name);
			student.setEmail(email);
//			studentDao.saveStudent(student);
			System.out.println("which subject do you want to study");
			boolean flag = true;
			while (flag) {
				System.out.println("101.java \n 102.HTML \n 103.sql\n1.exit");
				System.out.println("enter your choice");
				int choice1 = sc.nextInt();
				switch (choice1) {
				case 101:
					Subject subject = subjectDao.findById(choice1);
					list.add(subject);
					break;
				case 102:
					Subject subject1 = subjectDao.findById(choice1);
					list.add(subject1);
					break;
				case 103:
					Subject subject3 = subjectDao.findById(choice1);
					list.add(subject3);
					break;
				case 1:
					flag = false;
				}

			}
			student.setSubject(list);
			studentDao.saveStudent(student);
		}
			break;
		case 3: {

			System.out.println("enter id of the student");
			int id1 = sc.nextInt();
			Student student1 = studentDao.findById(id1);
			List<Subject> list2 = student1.getSubject();
			if (student1 != null) {
				System.out.println("select the subject");
				boolean flag1 = true;
				while (flag1) {
					System.out.println("101.java\n 102.HTML \n 103.sql\n 1.exit");
					System.out.println("enter choice");
					int choice2 = sc.nextInt();
					switch (choice2) {
					case 101:
						Subject subject = subjectDao.findById(choice2);
						list2.add(subject);
						break;
					case 102:
						Subject subject1 = subjectDao.findById(choice2);
						list2.add(subject1);
						break;
					case 103:
						Subject subject3 = subjectDao.findById(choice2);
						list2.add(subject3);
						break;
					case 1:
						flag1 = false;

					}

				}
				System.out.println(list2);
				student1.setSubject(list2);
				studentDao.saveStudent(student1);
				System.out.println("get lost");
			}

		}
		case 4:
			System.out.println("1.update name");
			System.out.println("2.update email");
			System.out.println("3.exit");
			System.out.println("enter choice");
			int choice3 = sc.nextInt();
			switch (choice3) {
			case 1:
				System.out.println("enter id ");
				int id = sc.nextInt();
				System.out.println("enter name to be updated");
				String name = sc.next();
				Student student1 = studentDao.findById(id);
				if (student1 != null) {
					student1.setName(name);
					studentDao.update(student1);
				} else {
					System.out.println("enter existing id");
				}
				break;
			case 2:
				System.out.println("enter id");
				int id1 = sc.nextInt();
				Student student2 = studentDao.findById(id1);
				System.out.println("enter email to be updated");
				String email = sc.next();
				if (student2 != null) {
					student2.setEmail(email);
					studentDao.update(student2);
				} else {
					System.out.println("enter exsisting id");
				}
				break;
			case 3:
				System.out.println("thank you");
				break;
			}
		case 5:
			System.out.println("enter id");
			int id = sc.nextInt();
			Student student3 = studentDao.findById(id);
			System.out.println("=====details+========");
			System.out.println(student3);
			break;
		case 6:
			List<Student> student4 = studentDao.fecthAll();
			for (Student student2 : student4) {
				System.out.println(student2);
			}
			break;
		case 7:
			System.out.println("enter id");
			int id2= sc.nextInt();
			studentDao.delete(id2);
			break;
			
		case 8:
			System.out.println("enter subject id");
			int id4=sc.nextInt();
		Subject subject	=subjectDao.findById(id4);
		System.out.println(subject);
		break;
		
		case 9:
		List<Subject> subject5 =  subjectDao.fecthAll();
		for (Subject subject3 : subject5) {
			System.out.println(subject3);
		}
			break;
			
		}

	}
}
