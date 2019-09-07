package com.meiyingying.springboot.controller;

import com.meiyingying.springboot.model.AjaxResponse;
import com.meiyingying.springboot.model.Article;
import com.meiyingying.springboot.service.ArticleRestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;



@Controller
@Slf4j
@RequestMapping("/rest")
public class ArticleRestController {

    @Resource
    ArticleRestService articleRestService;

//    @RequestMapping(value = "/article", method = POST, produces = "application/json")
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response=AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)

    })
    @PostMapping(value = "/article",  produces = "application/json")
    @ResponseBody
    public AjaxResponse saveArticle(@RequestBody Article article){
        log.info("saveArticle:{}",article);

        log.info("articleRestService return:",articleRestService.saveArtice(article));

        return AjaxResponse.success(article);
    }

    @DeleteMapping("/article/{id}")
    @ResponseBody
    public AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}", id);
        return AjaxResponse.success();
    }

//    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping(value = "/article/{id}", produces = "application/json")
    @ResponseBody
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article){
        article.setId(id);
        log.info("putArticle:{}",article);
        return AjaxResponse.success();
    }

    @GetMapping("article/{id}")
    @ResponseBody
    public AjaxResponse getArticle(@PathVariable Long id){
        Article article = Article.builder().id(1L).author("曹红梅").content("spring boot 学习").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article);
    }

}
