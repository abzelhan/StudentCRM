package com.abzal.endterm.service;

import com.abzal.endterm.dao.EducationHistoryDao;
import com.abzal.endterm.model.EducationHistory;
import com.abzal.endterm.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
@Service("eduHisService")
@Transactional
public class EducationHistoryService {

    @Autowired
    EducationHistoryDao educationHistoryDao;

    public void save(EducationHistory educationHistory){
        educationHistoryDao.save(educationHistory);
    }

    public EducationHistory getById(int id){
       return educationHistoryDao.getByKey(id);
    }

    public void delete(EducationHistory educationHistory){
        educationHistoryDao.delete(educationHistory);
    }

    public ArrayList<EducationHistory> getAll(Student student){
        return educationHistoryDao.getAll(student);
    }

}
