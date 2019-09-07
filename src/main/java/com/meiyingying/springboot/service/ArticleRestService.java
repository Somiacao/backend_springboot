package com.meiyingying.springboot.service;

import com.meiyingying.springboot.model.AjaxResponse;
import com.meiyingying.springboot.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {

    public String saveArtice(Article article){
        log.info("saveArticle:{}",article);
        return "测试";
    }

}
