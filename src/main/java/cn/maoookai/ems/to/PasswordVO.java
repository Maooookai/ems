package cn.maoookai.ems.to;

import lombok.Data;

@Data
public class PasswordVO {

    private String oldPassword;

    private String newPassword;

    private String newPasswordCheck;

}
