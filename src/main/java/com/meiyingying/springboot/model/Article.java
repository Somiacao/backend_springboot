package com.meiyingying.springboot.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
// 改变json字符串体内的顺序
@JsonPropertyOrder(value = {"content", "title"})
public class Article {
//    排除属性不做序列化操作
    @JsonIgnore
    private long id;
//    为属性起一个别名
//    @JsonProperty("authorAlias")
    private String author;
    private String title;
    private String content;
// 排除为空的元素不做序列化反序列化
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Reader> reader;


}
