package net.javaguides.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		/**
		 * Student student1 = new Student("Marlon", "Couto", "yuelami@gmail.com");
		 *	studentRepository.save(student1);
		 *
		 *	Student student2 = new Student("Ramesh", "Jadhav", "rameshjadhav@gmail.com");
		 *	studentRepository.save(student2);
		 *
		 *	Student student3 = new Student("Tony", "Stark", "tony_stark@gmail.com");
		 *	studentRepository.save(student3);
		 */
	}

}
