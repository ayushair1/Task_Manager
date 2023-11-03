package com.consultadd.Taskmanager.service;

import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public Object signUp(UserEntity userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public Object login(UserEntity userEntity) throws Exception {
        Optional<UserEntity> userDb=userRepository.findByUsername(userEntity.getUsername());



        if(!userDb.isPresent()){
            throw new Exception("User Not found");

        }
        String storePassword,currentPassword;
        storePassword=userDb.get().getPassword();
        currentPassword=userEntity.getPassword();
        if(storePassword.equals(currentPassword))
            return userDb.get();
        return new Exception("Invalid Credentials");
    }
}
