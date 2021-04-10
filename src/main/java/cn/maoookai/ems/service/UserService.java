package cn.maoookai.ems.service;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.to.UserAddVO;
import cn.maoookai.ems.to.UserEditVO;
import cn.maoookai.ems.to.UserSearchVO;
import cn.maoookai.ems.to.UserVO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    Page<User> list(int page);

    User getUserById(long id);

    void add(UserAddVO vo);

    void edit(UserEditVO vo,Long id);

    List<User> search(UserSearchVO vo);

}
