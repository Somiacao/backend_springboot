package com.meiyingying.springboot.restful;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meiyingying.springboot.controller.ArticleRestController;
import com.meiyingying.springboot.model.Article;
import com.meiyingying.springboot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
//@SpringBootTest
//限制到ArticleRest
//@WebMvcTest(ArticleRestController.class)
@WebMvcTest
public class ArticleRestControllerTestModified2 {
    @Resource
    private MockMvc mockMvc;


    @MockBean
    ArticleRestService articleRestService;

//    @Before
//    public void setUp(){
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
//    }

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                " \"id\" : 1, \n"+
                " \"author\" : \"曹红梅\",\n"+
                " \"title\" : \"spring boot学习\", \n"+
                " \"content\" : \"c\",\n"+
                " \"createTime\" : \"2019-09-09 09:09:09\",\n"+
                " \"reader\" : [{\"name\": \"曹红梅\", \"age\":18}, {\"name\":\"张政豪\",\"age\":18}]\n"+
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        Article article1 = objectMapper.readValue(article, Article.class);
//        articleRestService.saveArtice(article1);

//        打桩
        when( articleRestService.saveArtice(article1)).thenReturn("ok");

//        模拟发送网络请求
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/article")
                .contentType("application/json").content(article))
//                时间解析有问题
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
//                设置了变量的别名，导致出错
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("曹红梅"))
                .andDo(print())
                .andReturn();


        log.info(result.getResponse().getContentAsString());
    }
}
