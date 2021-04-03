package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.repository.UserRepository;
import cn.maoookai.ems.service.UserService;
import cn.maoookai.ems.to.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public UserVO info(long id) {
        UserVO user = new UserVO();
        if (userRepository.findById(id).isPresent())
            user.setUsername(userRepository.findById(id).get().getName());
        return user;
    }
}
