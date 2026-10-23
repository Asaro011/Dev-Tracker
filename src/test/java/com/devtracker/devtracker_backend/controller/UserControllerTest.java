package com.devtracker.devtracker_backend.controller;

import com.devtracker.devtracker_backend.dto.UserRequest;
import com.devtracker.devtracker_backend.entity.User;
import com.devtracker.devtracker_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldListUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(List.of(new User()));

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateUser() throws Exception {
        User user = new User();
        user.setName("Ana");
        user.setEmail("ana@test.com");
        user.setPassword("123456");

        when(userService.createUser(any(UserRequest.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Ana\",\"email\":\"ana@test.com\",\"password\":\"123456\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("ana@test.com"));
    }
}
