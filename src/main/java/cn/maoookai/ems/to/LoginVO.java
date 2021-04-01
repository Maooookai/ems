package cn.maoookai.ems.to;

import lombok.Data;

@Data
public class LoginVO {

    private boolean needModifyPassword;

    private boolean isAdmin;

    private boolean isSuccess;

    private String message;

}
