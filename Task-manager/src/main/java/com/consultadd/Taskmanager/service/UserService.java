package com.consultadd.Taskmanager.service;

import com.consultadd.Taskmanager.entity.UserEntity;

public interface UserService {
    Object signUp(UserEntity userModel);

    Object login(UserEntity userModel) throws Exception;
}
