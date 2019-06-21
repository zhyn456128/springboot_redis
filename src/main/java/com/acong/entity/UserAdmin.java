package com.acong.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@Repository
public class UserAdmin implements Serializable {

    private int user_id;
    private String user_name;
    private String user_password;

    public UserAdmin(int user_id,String user_name,String user_password){
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public  UserAdmin(){
        super();
    }
}
