package com.acong.dao;

import com.acong.entity.UserAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface UserAdminDao {
    List<UserAdmin> queryAll();
    UserAdmin findUserAdminById(int user_id);
    int deleteById(int user_id);
    int updateUserAdmin(@Param("useradmin") UserAdmin userAdmin);
    int insertUserAdmin(@Param("useradmin") UserAdmin userAdmin);

    List<UserAdmin> findUserAdminByName(String user_name);
}
