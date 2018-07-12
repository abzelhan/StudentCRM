package com.abzal.endterm.dao;

import com.abzal.endterm.model.Student;

public interface StudentDao {
    void save(Student student);
    Student findStudentByUserId(int userId);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}
