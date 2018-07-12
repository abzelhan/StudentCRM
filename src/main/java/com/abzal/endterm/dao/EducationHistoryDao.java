package com.abzal.endterm.dao;

import com.abzal.endterm.model.EducationHistory;
import com.abzal.endterm.model.Student;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository("eduHistRep")
public class EducationHistoryDao extends AbstractDao<Integer,EducationHistory> {

    public void save(EducationHistory educationHistory){
        persist(educationHistory);
    }

    public ArrayList<EducationHistory> getAll(Student student){
        Criteria entityCriteria = createEntityCriteria();
        entityCriteria.add(Restrictions.eq("student",student));

        return (ArrayList<EducationHistory>) entityCriteria.list();
    }



}
