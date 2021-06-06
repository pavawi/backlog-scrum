package com.zhonyang.scrum.backlog.modules.base.controller;

import com.zhonyang.scrum.backlog.common.api.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ResponseTestControllerTest {

    @Autowired
    private ResponseTestController responseTestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNotNull() {
        Assertions.assertThat(responseTestController).isNotNull();
    }

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(Result.ofSuccess("test").buildResultJson()));
    }

    @Test
    void testNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/null"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(Result.ofSuccess().buildResultJson()));
    }

    @Test
    void objectNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/object"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testListNull() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/list"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(Result.ofSuccess(null).buildResultJson()));
    }

    @Test
    void ignore() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/ignore"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Ignore"));
    }

    @Test
    void businessError() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/test/businessError"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(Result.ofFail(0, "异常演示").buildResultJson()));
    }

}