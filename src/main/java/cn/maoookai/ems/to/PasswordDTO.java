package cn.maoookai.ems.to;

import cn.maoookai.ems.entity.User;
import lombok.Data;

@Data
public class PasswordDTO {

    private User user;

    private PasswordVO vo;

}
