package cn.maoookai.ems.to;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotNull
    private String id;

    @NotNull
    private String password;

}
