package co.edu.ocu.ti.demobackend.services;

import co.edu.ocu.ti.demobackend.respositories.User;
import co.edu.ocu.ti.demobackend.respositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleService roleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository, roleService);
    }

    @Test
    void create() {
        User manuela = new User("3", "MANUELA", LocalDateTime.now());
        when(userRepository.save(manuela)).thenReturn(manuela);
        User save = userService.create(manuela);
        assertNotNull(save);
        assertEquals("MANUELA", save.getName());
    }

    @Test
    void listAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("1", "MANUEL", LocalDateTime.now()));
        users.add(new User("2", "VALENTINA", LocalDateTime.now()));
        users.add(new User("3", "PAULA", LocalDateTime.now()));
        when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.listAllUsers();
        assertNotNull(users);
        assertEquals(3,result.size());
    }

    @Test
    void update() {

    }

    @Test
    void listAllUsersActive() {

    }
}