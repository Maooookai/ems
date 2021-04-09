package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.repository.UserRepository;
import cn.maoookai.ems.service.UserService;
import cn.maoookai.ems.to.UserAddVO;
import cn.maoookai.ems.to.UserSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<User> search(UserSearchVO vo) {
        switch (vo.getBy()) {
            case "id": {
                if (!userRepository.findAllByIdContains(Long.valueOf(vo.getContent())).isEmpty())
                    return userRepository.findAllByIdContains(Long.valueOf(vo.getContent()));
                else return new ArrayList<>();
            }
            case "name": {
                if (!userRepository.findAllByNameContains(vo.getContent()).isEmpty())
                    return userRepository.findAllByNameContains(vo.getContent());
                else return new ArrayList<>();
            }
            case "phone": {
                if (!userRepository.findAllByPhoneNumberContains(vo.getContent()).isEmpty())
                    return userRepository.findAllByPhoneNumberContains(vo.getContent());
                else return new ArrayList<>();
            }
            case "address": {
                if (!userRepository.findAllByAddressContains(vo.getContent()).isEmpty())
                    return userRepository.findAllByAddressContains(vo.getContent());
                else return new ArrayList<>();
            }
            case "idNumber": {
                if (!userRepository.findAllByIdNumberContains(vo.getContent()).isEmpty())
                    return userRepository.findAllByIdNumberContains(vo.getContent());
                else return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
