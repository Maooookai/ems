package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.repository.UserRepository;
import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.to.LoginDTO;
import cn.maoookai.ems.to.LoginVO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LoginVO login(@NotNull LoginDTO dto) {
        LoginVO loginVO = new LoginVO();
        if (dto.getId().isEmpty()) {
            loginVO.setSuccess(false);
            return loginVO;
        }
        if (userRepository.findById(Long.valueOf(dto.getId())).isEmpty()) {
            loginVO.setSuccess(false);
            loginVO.setMessage("该用户不存在！");
        } else {
            User user = userRepository.findById(Long.valueOf(dto.getId())).get();
            if (user.getPassword().equals(dto.getPassword())) {
                loginVO.setAdmin(user.isAdmin());
                loginVO.setSuccess(true);
            } else {
                loginVO.setSuccess(false);
                loginVO.setMessage("用户名或密码错误！");
            }
        }
        return loginVO;
    }
}
