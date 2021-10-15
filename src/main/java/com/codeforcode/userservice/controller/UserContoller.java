package com.codeforcode.userservice.controller;

import com.codeforcode.userservice.entity.User;
import com.codeforcode.userservice.responsemodule.UserDepartmentResponse;
import com.codeforcode.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserContoller {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public UserDepartmentResponse findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }
}
