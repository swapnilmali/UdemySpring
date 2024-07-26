package main.DAO;

import jakarta.persistence.TypedQuery;
import main.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    // inject using constructor
        @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method

    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);

    }

    public Student findbyID(Integer id){
           return entityManager.find(Student.class, id);

    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> selectStudent = entityManager.createQuery("from Student", Student.class);
        return selectStudent.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }
}
