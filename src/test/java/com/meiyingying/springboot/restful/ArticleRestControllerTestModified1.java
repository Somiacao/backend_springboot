package com.meiyingying.springboot;

import com.meiyingying.springboot.controller.ArticleRestController;
import com.meiyingying.springboot.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ArticleRestControllerTestModified1 {
    @Resource
    private MockMvc mockMvc;

    @Resource
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
