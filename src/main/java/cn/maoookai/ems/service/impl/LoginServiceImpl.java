package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.repository.UserRepository;
import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.to.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public String login(LoginDTO dto) {

        return null;
    }
}
