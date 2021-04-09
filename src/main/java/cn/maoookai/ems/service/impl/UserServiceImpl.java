package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.repository.UserRepository;
import cn.maoookai.ems.service.UserService;
import cn.maoookai.ems.to.UserAddVO;
import cn.maoookai.ems.to.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> list(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        return userRepository.findAll(pageable);
    }

    @Override
    public UserVO info(long id) {
        UserVO user = new UserVO();
        if (userRepository.findById(id).isPresent())
            user.setUsername(userRepository.findById(id).get().getName());
        return user;
    }

    @Override
    public User getUserById(long id) {
        if (userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return new User();
    }

    @Override
    public void add(UserAddVO vo) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        User newUser = new User();
        newUser.setName(vo.getName());
        newUser.setAddress(vo.getAddress());
        newUser.setAdmin(vo.isAdmin());
        newUser.setGender(vo.getGender());
        newUser.setElectType(vo.isElectType());
        newUser.setPassword(vo.getPassword());
        newUser.setPhoneNumber(vo.getPhone());
        newUser.setIdNumber(vo.getIdNumber());
        newUser.setRegisterTime(simpleDateFormat.format(new Date()));
        userRepository.save(newUser);
    }
}
