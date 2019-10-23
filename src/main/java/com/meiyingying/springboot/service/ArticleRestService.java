package com.meiyingying.springboot.service;

import com.meiyingying.springboot.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {

    public String saveArtice(ArticleVO articleVO){
        log.info("saveArticle:{}", articleVO);
        return "测试";
    }

}
