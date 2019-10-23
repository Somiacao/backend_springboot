package com.meiyingying.springboot.controller;

import com.meiyingying.springboot.model.AjaxResponse;
import com.meiyingying.springboot.model.ArticleVO;
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

//    @RequestMapping(value = "/articleVO", method = POST, produces = "application/json")
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "ArticleVO", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response=AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)

    })


    @PostMapping(value = "/article")
    @ResponseBody
    public AjaxResponse saveArticle(@RequestBody ArticleVO articleVO){
        log.info("saveArticle:{}", articleVO);

//        log.info("articleRestService return:",articleRestService.saveArtice(articleVO));

        return AjaxResponse.success(articleVO);
    }

    @DeleteMapping("/article/{id}")
    @ResponseBody
    public AjaxResponse deleteArticle(@PathVariable Long id){
        log.info("deleteArticle:{}", id);
        return AjaxResponse.success();
    }

//    @RequestMapping(value = "/articleVO/{id}", method = PUT, produces = "application/json")
    @PutMapping(value = "/article/{id}", produces = "application/json")
    @ResponseBody
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO articleVO){
        articleVO.setId(id);
        log.info("putArticle:{}", articleVO);
        return AjaxResponse.success();
    }

    @GetMapping("article/{id}")
    @ResponseBody
    public AjaxResponse getArticle(@PathVariable Long id){
        ArticleVO articleVO = ArticleVO.builder().id(1L).author("曹红梅").content("spring boot 学习").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(articleVO);
    }

}
