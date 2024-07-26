package main;

import main.DAO.StudentDAO;
import main.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudappApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {//createStudent(studentDAO);
			//createMultiStudent(studentDAO);
			//readStudent(studentDAO);
			//getallStudent(studentDAO);
			updateAll(studentDAO);
		};

}

	private void updateAll(StudentDAO studentDAO) {
		int studentID = 1;
		Student student = studentDAO.findbyID(studentID); // get student by ID to update
		student.setFirstName("Swap"); //update value using setter method of entity class
		studentDAO.update(student); //use merger method to update DB
		System.out.println(student);
	}

	private void getallStudent(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.findAll();
		for(Student i: allStudents) {
			System.out.println(i);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student
		Student newstudent = new Student("Rakesh", "mane","rakesh@gmail.com");
		studentDAO.save(newstudent);

		int id = newstudent.getId();
		Student st = studentDAO.findbyID(id);
		System.out.println("Read Id: "+st.toString());
	}

	private static void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating student object");
		Student theStudent = new Student("Swapnil","Mali","swapnil.mali@gmail.com");

		//save the student object
        studentDAO.save(theStudent);

		//display id of saved student
		System.out.println("Saved Student generated id: "+theStudent.getId());

	}

	private static void createMultiStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("creating student object");
		Student theStudent2 = new Student("Nikita","Yamgar","nikki@gmail.com");
		Student theStudent3 = new Student("Nikita","Mali","nikki.mali@gmail.com");

		//save the student object
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);


	}

}
