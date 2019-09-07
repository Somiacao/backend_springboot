package com.meiyingying.springboot.model.yml;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Friend {
    private String hobby;
    @NotEmpty
    private String sex;
}
