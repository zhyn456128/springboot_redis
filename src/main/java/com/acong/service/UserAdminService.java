package com.acong.service;

import com.acong.dao.UserAdminDao;
import com.acong.entity.UserAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdminService {
    @Autowired
    UserAdminDao userAdminDao;

    @Autowired
    UserAdmin userAdmin;

    @Autowired
    RedisTemplate redisTemplate;

//    @Autowired(required = false)
//    public void setRedisTemplate(RedisTemplate redisTemplate){
//        RedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(stringSerializer);
//        this.redisTemplate = redisTemplate;
//    }

    public List<UserAdmin> queryall(){
        return userAdminDao.queryAll();
    }

    public UserAdmin findUserAdminById(int user_id){
        String key = "user_"+user_id;
        ValueOperations<String, UserAdmin> operations = redisTemplate.opsForValue();
        boolean haskey = redisTemplate.hasKey(key);
        if(haskey){
            userAdmin = operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            System.out.println(userAdmin.getUser_name());
            System.out.println("==============================");
        }else{
            userAdmin = userAdminDao.findUserAdminById(user_id);
            System.out.println("==========从数据表中获得数据=========");
            System.out.println(userAdmin.getUser_name());
            System.out.println("==============================");

            //写入缓存
            operations.set(key,userAdmin);
        }
        return userAdmin;
    }

    @Cacheable(value = "cache1",key = "#user_name+'zzzzz'")
//    @Cacheable(value = "cache1")

    public List<UserAdmin> findUserAdminByName(String user_name){
        return userAdminDao.findUserAdminByName(user_name);
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
