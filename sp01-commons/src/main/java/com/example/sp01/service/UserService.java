package com.example.sp01.service;

import com.example.sp01.pojo.User;

public interface UserService {
    User getUser(Integer id);
    void addScore(Integer id, Integer score);
}