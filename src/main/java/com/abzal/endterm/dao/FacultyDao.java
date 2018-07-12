package com.abzal.endterm.dao;

import com.abzal.endterm.model.Faculty;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("facultyRepository")
public class FacultyDao extends AbstractDao<Integer,Faculty> {

public ArrayList<Faculty> getAllFaculties(){
    return (ArrayList<Faculty>) createEntityCriteria().list();
}

}
