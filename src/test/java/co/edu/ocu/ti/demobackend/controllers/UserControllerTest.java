package co.edu.ocu.ti.demobackend.controllers;

import co.edu.ocu.ti.demobackend.models.UserStatus;
import co.edu.ocu.ti.demobackend.respositories.User;
import co.edu.ocu.ti.demobackend.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "MANUEL", LocalDateTime.now()));
        users.add(new User("2", "VALENTINA", LocalDateTime.now()));
        User paula = new User("3", "PAULA", LocalDateTime.now());
        paula.setStatus(UserStatus.ACTIVE);
        users.add(paula);
        Mockito.when(userService.listAllUsers()).thenReturn(users);
        Mockito.when(userService.listAllUsersActive()).thenReturn(new ArrayList<>(List.of(paula)));
    }

    @Test
    void listAllUser() throws Exception {
        this.mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status()
                        .isOk());
    }

    @Test
    void listAllUserActive() throws Exception {
        this.mockMvc.perform(get("/users/actives"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].name").value("PAULA"))
                .andExpect(status().isOk());
    }
}