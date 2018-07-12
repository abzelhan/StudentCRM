package com.abzal.endterm.service;

import com.abzal.endterm.dao.SpecialtyDao;
import com.abzal.endterm.model.Specialty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("specialtyService")
@Transactional
public class SpecialtyService {

    @Autowired
    SpecialtyDao specialtyDao;

    public ArrayList<Specialty> getAllSpecialties(){
        return specialtyDao.getAllSpecialties();
    }

    public Specialty getById(int id){
        return specialtyDao.getByKey(id);
    }

    public Specialty getSpecialtyByName(String name) {
        return specialtyDao.getSpecialtyByName(name);
    }

}
