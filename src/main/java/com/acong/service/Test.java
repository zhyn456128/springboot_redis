package com.acong.service;

import com.acong.entity.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Test {
    @Autowired
    UserAdminService userAdminService;
    @Autowired
    UserAdmin userAdmin;

    @Transactional
    public void t(){
        userAdmin.setUser_id(1);
        userAdmin.setUser_name("dedfef");
        userAdmin.setUser_password("ghcdsku");
        userAdminService.updateUserAdmin(userAdmin);

        if(true){
            throw new RuntimeException("超时");
        }
    }
}
