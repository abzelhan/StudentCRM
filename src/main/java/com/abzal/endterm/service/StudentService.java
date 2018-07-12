package com.abzal.endterm.service;

import com.abzal.endterm.model.Student;

public interface StudentService {
    void save(Student student);
    Student findStudentByUserId(int userId);
    void update(Student student);
    void delete(Student student);
}
