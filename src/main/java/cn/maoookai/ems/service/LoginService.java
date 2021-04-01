package cn.maoookai.ems.service;

import cn.maoookai.ems.to.LoginDTO;
import cn.maoookai.ems.to.LoginVO;

public interface LoginService {

    LoginVO login(LoginDTO dto);

}
