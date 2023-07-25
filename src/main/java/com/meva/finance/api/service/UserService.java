package com.meva.finance.api.service;

import com.meva.finance.api.model.User;
import com.meva.finance.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //Entende que é uma classe Service
public class UserService {

    private static UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User register(User user){
        return userRepository.save(user);

    }
//    //Criei Sozinho
//
//    public static User save(User user) {
//        return userRepository.save(user);
//    }



}
