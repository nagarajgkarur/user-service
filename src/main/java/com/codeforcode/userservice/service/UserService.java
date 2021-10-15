package com.codeforcode.userservice.service;

import com.codeforcode.userservice.entity.User;
import com.codeforcode.userservice.repository.UserRepository;
import com.codeforcode.userservice.responsemodule.Department;
import com.codeforcode.userservice.responsemodule.UserDepartmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public User save(User user){
        return userRepository.save(user);
    }

    public UserDepartmentResponse findUserById(Long id){
        Optional<User> optional = userRepository.findById(id);
        UserDepartmentResponse userDepartmentResponse = new UserDepartmentResponse();
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }
        if(user != null){
            Department department = restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(), Department.class);
            userDepartmentResponse.setUser(user);
            userDepartmentResponse.setDepartment(department);
        }
        return userDepartmentResponse;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }


}
