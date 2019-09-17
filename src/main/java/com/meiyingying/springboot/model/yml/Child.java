package com.meiyingying.springboot.model.yml;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class Child {
    @NotEmpty
    private String name;
    private int age;
    private List<Friend> friends;
}
