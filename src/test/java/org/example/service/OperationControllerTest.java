package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.SpringBoot2TestApplication;
import org.example.controller.OperationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URI;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class OperationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
        Map<String, String> requestBody = Map.of(
                "name1", "value1",
                "name2", "value2");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post(URI.create("/api/operation/123"))
                        .header("Token", "token")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    void test2() throws Exception {
        Map<String, String> requestBody = Map.of(
                "name1", "value1",
                "name2", "value2");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post(URI.create("/api/test/123"))
                        .header("Token", "token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
    @Test
    void test3() throws Exception {
        Map<String, String> requestBody = Map.of(
                "name1", "value1",
                "name2", "value2");
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(MockMvcRequestBuilders.post(URI.create("/api/test/123"))
                        .header("Token", "token")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}
