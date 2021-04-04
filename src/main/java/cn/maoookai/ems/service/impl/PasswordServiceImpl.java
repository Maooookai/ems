package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.repository.UserRepository;
import cn.maoookai.ems.service.PasswordService;
import cn.maoookai.ems.to.PasswordDTO;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {

    UserRepository repository;

    public PasswordServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public String modifyPassword(PasswordDTO dto) {
        User user = dto.getUser();
        if (!dto.getVo().getNewPassword().equals(dto.getVo().getNewPasswordCheck()))
            return "两次输入密码不一致！";
        else {
            if (user.getPassword().equals(dto.getVo().getOldPassword())) {
                if (dto.getVo().getOldPassword().equals(dto.getVo().getNewPassword()))
                    return "新密码不能与旧密码相同！";
                user.setPassword(dto.getVo().getNewPassword());
                repository.save(user);
                return "密码修改成功！";
            } else
                return "原密码不正确！";
        }
    }
}
