package com.consultadd.Taskmanager.Controller;

import com.consultadd.Taskmanager.entity.UserEntity;
import com.consultadd.Taskmanager.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    ResponseEntity<?> signUp(@RequestBody UserEntity userEntity){


        return ResponseEntity.status(200).body(userService.signUp(userEntity));
    }
    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserEntity userEntity) throws Exception {
        return ResponseEntity.status(200).body(userService.login(userEntity));

    }
}
