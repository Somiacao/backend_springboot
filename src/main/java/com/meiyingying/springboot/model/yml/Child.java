package com.meiyingying.springboot.model.yml;

import lombok.Data;

import java.util.List;

@Data
public class Child {
    private String name;
    private int age;
    private List<Friend> friends;
}
