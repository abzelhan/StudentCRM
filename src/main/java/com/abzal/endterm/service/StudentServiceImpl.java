package com.abzal.endterm.service;

import com.abzal.endterm.dao.StudentDao;
import com.abzal.endterm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student findStudentByUserId(int userId) {
        return studentDao.findStudentByUserId(userId);
    }

    @Override
    public void update(Student student) {
       studentDao.updateStudent(student);
    }

    @Override
    public void delete(Student student) {
        studentDao.deleteStudent(student);
    }
}
