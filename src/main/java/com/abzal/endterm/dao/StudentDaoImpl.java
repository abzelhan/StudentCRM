package com.abzal.endterm.dao;

import com.abzal.endterm.model.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student> implements StudentDao {
    @Override
    public void save(Student student) {
       persist(student);
    }

    @Override
    public Student findStudentByUserId(int userId) {
        Criteria criteria = getSession().createCriteria(Student.class);
        criteria.add(Restrictions.eq("idUser",userId));
        return (Student) criteria.uniqueResult();
    }

    @Override
    public void updateStudent(Student student) {
        update(student);
    }

    @Override
    public void deleteStudent(Student student) {
        delete(student);
    }


}
