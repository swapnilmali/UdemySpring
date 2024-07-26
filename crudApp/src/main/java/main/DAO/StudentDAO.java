package main.DAO;

import main.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findbyID(Integer id);
    List<Student> findAll();
    void update(Student theStudent);
}
