package com.meiyingying.springboot.model.yml;

import com.meiyingying.springboot.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Component
//用于属性校验
@Validated
@ConfigurationProperties(prefix = "family")
//加载外部yml文件
@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
//加载properties文件
//@PropertySource(value = "classpath:family.properties")
public class Family {
//    @Value("${family.family-name}")
    @NotEmpty
    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;

}
