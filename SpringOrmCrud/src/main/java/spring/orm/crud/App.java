package spring.orm.crud;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.orm.crud.dao.StudentDao;
import spring.orm.crud.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = applicationContext.getBean(StudentDao.class);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Choose an operation:");
			System.out.println("1. Create Student");
			System.out.println("2. Read Student by ID");
			System.out.println("3. Read all Students");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter Student Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Department: ");
				String department = scanner.nextLine();
				System.out.print("Enter RollNumber: ");
				String rollNumber = scanner.nextLine();
				System.out.print("Enter Age: ");
				Integer age = scanner.nextInt();

				Student student = new Student();
				student.setName(name);
				student.setDepartment(department);
				student.setRollNumber(rollNumber);
				student.setAge(age);
				studentDao.addStudent(student);
				System.out.println("User created successfully!");
				break;

			case 2:
				System.out.print("Enter Student ID: ");
				Integer id = scanner.nextInt();
				Student studentById = studentDao.getStudent(id);
				System.out.println("=================================================");
				if (studentById != null) {

					System.out.println("Student Name: " + studentById.getName());
					System.out.println("Student Department: " + studentById.getDepartment());
					System.out.println("Student RollNumber: " + studentById.getRollNumber());
					System.out.println("Student Age: " + studentById.getAge());
				} else {
					System.out.println("Student not found!");
				}
				System.out.println("=================================================");
				break;
			case 3:
				List<Student> studentsList = studentDao.getStudents();
				System.out.println("=================================================");
				System.out.println("Students:");
				for (Student s : studentsList) {
					System.out.println("Student ID: " + s.getId());
					System.out.println("Student Name: " + s.getName());
					System.out.println("Student Department: " + s.getDepartment());
					System.out.println("Student RollNumber: " + s.getRollNumber());
					System.out.println("Student Age: " + s.getAge());
					System.out.println("=================================================");

				}
				break;
			case 4:
				System.out.print("Enter user ID: ");
				Integer updateId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter Updated Student Name: ");
				String updatedName = scanner.nextLine();
				System.out.print("Enter Updated Department: ");
				String updatedDepartment = scanner.nextLine();
				System.out.print("Enter Updated RollNumber: ");
				String updatedRollNumber = scanner.nextLine();
				System.out.print("Enter Updated Age: ");
				Integer updatedAge = scanner.nextInt();

				Student updatedStudent = new Student();
				updatedStudent.setId(updateId);
				updatedStudent.setName(updatedName);
				updatedStudent.setDepartment(updatedDepartment);
				updatedStudent.setRollNumber(updatedRollNumber);
				updatedStudent.setAge(updatedAge);
				studentDao.updateStudent(updatedStudent);
				System.out.println("Student updated successfully!");
				System.out.println("User updated successfully!");

				break;
			case 5:
				System.out.print("Enter Student ID to delete: ");
				Integer deleteId = scanner.nextInt();
				studentDao.deleteStudent(deleteId);
				System.out.println("Student deleted successfully!");
				break;
			case 6:
				System.out.println("Exiting...");
				System.exit(0);
			default:
				System.out.println("Invalid choice! Please enter a number between 1 and 6.");
			}
		}
	}
}
