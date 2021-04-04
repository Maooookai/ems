package cn.maoookai.ems.to;

import lombok.Data;

@Data
public class LoginVO {

    private boolean isAdmin;

    private boolean isSuccess;

    private String message;

}
