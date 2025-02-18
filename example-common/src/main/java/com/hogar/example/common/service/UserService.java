package com.hogar.example.common.service;

import com.hogar.example.common.model.User;

public interface UserService {
    User getUser(User user);

    default short getNumber() {
        return 6;
    }
}
