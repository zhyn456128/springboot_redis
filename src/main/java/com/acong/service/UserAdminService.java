package com.acong.service;

import com.acong.dao.UserAdminDao;
import com.acong.entity.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdminService {
    @Autowired
    UserAdminDao userAdminDao;

    public List<UserAdmin> queryall(){
        return userAdminDao.queryAll();
    }

    public UserAdmin findUserAdminById(int user_id){
        UserAdmin userAdmin = userAdminDao.findUserAdminById(user_id);
        return userAdmin;
    }

    public int updateUserAdmin(UserAdmin userAdmin){
        int result = userAdminDao.updateUserAdmin(userAdmin);
        return result;
    }

    public int insertUserAdmin(UserAdmin userAdmin){
        return userAdminDao.insertUserAdmin(userAdmin);
    }

    public int deleteById(int user_id){
        return userAdminDao.deleteById(user_id);
    }
}
