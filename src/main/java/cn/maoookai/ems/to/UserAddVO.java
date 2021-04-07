package cn.maoookai.ems.to;

import lombok.Data;

@Data
public class UserAddVO {

    private String name;

    private String phone;

    private String gender;

    private String address;

    private boolean electType;

    private String idNumber;

    private String password;

    private boolean isAdmin;

}
