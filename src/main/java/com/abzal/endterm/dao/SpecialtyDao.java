package com.abzal.endterm.dao;

import com.abzal.endterm.model.Specialty;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("specialtyDao")
public class SpecialtyDao extends AbstractDao<Integer,Specialty> {

    public ArrayList<Specialty> getAllSpecialties(){
        return (ArrayList<Specialty>) createEntityCriteria().list();
    }


    public Specialty getSpecialtyByName(String name) {
        Criteria criteria = getSession().createCriteria(Specialty.class);
        criteria.add(Restrictions.eq("name",name));
        return (Specialty) criteria.uniqueResult();
    }
}
