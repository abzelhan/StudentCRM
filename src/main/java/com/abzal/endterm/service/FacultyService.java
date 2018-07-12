package com.abzal.endterm.service;

import com.abzal.endterm.dao.FacultyDao;
import com.abzal.endterm.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("facultyService")
@Transactional
public class FacultyService {

    @Autowired
    FacultyDao facultyDao;

    public ArrayList<Faculty> getAllFaculties(){
        return facultyDao.getAllFaculties();
    }

}
