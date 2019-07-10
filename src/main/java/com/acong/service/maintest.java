package com.acong.service;

import org.springframework.beans.factory.annotation.Autowired;

public class maintest {

    @Autowired
    Test test;

    public void ss(){
        test.t();
    }

    public static void main(String[] args) {
        maintest mm = new maintest();
        System.out.println(mm.toString());
    }


}
