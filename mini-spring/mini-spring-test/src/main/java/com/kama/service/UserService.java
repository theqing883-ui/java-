package com.kama.service;

import com.kama.repository.UserRepository;

public class UserService {
  private UserRepository userRepository;
    /*提供setter 共 xml 注入*/
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void doSomething(){
        System.out.println("UserService 开始调用");
        userRepository.printInfo();
    }
}
