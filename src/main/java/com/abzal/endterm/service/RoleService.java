package com.abzal.endterm.service;

import com.abzal.endterm.dao.RoleDao;
import com.abzal.endterm.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAllRoles() {
        return roleDao.findAllRoles();
    }

    public Role findById(int id){
        return roleDao.findById(id);
    }

}
