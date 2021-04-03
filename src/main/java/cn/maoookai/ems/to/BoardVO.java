package cn.maoookai.ems.to;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Validated
public class BoardVO {

    @NotNull
    private String time;

    @NotNull
    private String content;
}
