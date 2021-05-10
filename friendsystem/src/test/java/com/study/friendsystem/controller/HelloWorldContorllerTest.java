package com.study.friendsystem.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HelloWorldContorllerTest {
    @Autowired
    private HelloWorldContorller helloWorldContorller;

    private MockMvc mockMvc;
    //테스트 실행 crtl shift f10
    @Test
    public void helloWorld(){
//        System.out.println("test");
        System.out.println(helloWorldContorller.helloWorld());
        Assertions.assertEquals(helloWorldContorller.helloWorld(),"Hello World");
    }

    @Test
    void mockMvcTest() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(helloWorldContorller).build();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloworld")
        ).andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
        //status가 ok인지 예측 status:200

    }
}