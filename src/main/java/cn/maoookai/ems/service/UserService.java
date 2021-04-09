package cn.maoookai.ems.service;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.to.UserAddVO;
import cn.maoookai.ems.to.UserVO;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> list(int page);

    UserVO info(long id);

    User getUserById(long id);

    void add(UserAddVO vo);

}
