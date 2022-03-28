package co.edu.ocu.ti.demobackend.respositories;

import co.edu.ocu.ti.demobackend.models.UserStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(dataSource);
        assertNotNull(jdbcTemplate);
        assertNotNull(entityManager);
        assertNotNull(userRepository);
    }

    @BeforeEach
    void setUp() {
        User manuel = new User("1", "MANUEL", LocalDateTime.now());
        User valentina = new User("2", "VALENTINA", LocalDateTime.now());
        User paula = new User("3", "PAULA", LocalDateTime.now());
        Role admin = new Role("1", "ADMIN", "ADMINITRATOR");
        Role student = new Role("2", "STU", "STUDENT");
        manuel.setRole(List.of(admin,student));
        paula.setRole(List.of(student));
        valentina.setRole(List.of(student));
        userRepository.save(manuel);
        userRepository.save(valentina);
        userRepository.save(paula);
    }

    @Test
    void findByName2() {
        User manuel = userRepository.findByName2("MANUEL");
        assertNotNull(manuel);
        assertEquals("MANUEL", manuel.getName());
    }

    @Test
    void findByNameNative() {
        User manuel = userRepository.findByNameNative("MANUEL");
        assertNotNull(manuel);
        assertEquals("MANUEL", manuel.getName());
    }

    @Test
    void findByName() {
        User manuel = userRepository.findByName("MANUEL");
        assertNotNull(manuel);
        assertEquals("MANUEL", manuel.getName());
        assertEquals(2, manuel.getRole().size());
        assertEquals("ADMIN", manuel.getRole().get(0).getRole());
        assertEquals("STU", manuel.getRole().get(1).getRole());
        assertEquals(UserStatus.INACTIVE, manuel.getStatus());
    }

    @Test
    void findAllByRole(){
        Role student = new Role("2", "STU", "STUDENT");
        List<User> allUserByRole = userRepository.findAllByRole(student);
        assertNotNull(allUserByRole);
        assertEquals(3, allUserByRole.size());

        Role admin = new Role("1", "ADMIN", "ADMINITRATOR");
        List<User> allUserByRoleAdmin = userRepository.findAllByRole(admin);
        assertNotNull(allUserByRoleAdmin);
        assertEquals(1, allUserByRoleAdmin.size());
    }

}