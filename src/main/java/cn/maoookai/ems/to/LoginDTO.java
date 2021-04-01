package cn.maoookai.ems.to;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginDTO {

    @NotEmpty
    private long id;

    @NotNull
    private String password;

}
