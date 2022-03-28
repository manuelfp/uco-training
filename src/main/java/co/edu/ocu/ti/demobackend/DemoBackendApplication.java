package co.edu.ocu.ti.demobackend;

import co.edu.ocu.ti.demobackend.models.UserStatus;
import co.edu.ocu.ti.demobackend.respositories.Role;
import co.edu.ocu.ti.demobackend.respositories.User;
import co.edu.ocu.ti.demobackend.respositories.UserRepository;
import co.edu.ocu.ti.demobackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class DemoBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoBackendApplication.class, args);
    }

   /* @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;*/

    @Override
    public void run(String... args) throws Exception {

  /*      User manuel = new User("1", "MANUEL", LocalDateTime.now());
        User paula = new User("2", "PAULA", LocalDateTime.now());
        User manuela = new User("3", "MANUELA", LocalDateTime.now());
        Role admin = new Role(UUID.randomUUID().toString(), "ADMIN", "ADMINITRATOR");
        Role student = new Role(UUID.randomUUID().toString(), "STU", "STUDENT");
        manuel.setRole(List.of(admin,student));
        paula.setRole(List.of(student));
        manuela.setRole(List.of(student));
        userRepository.saveAll(List.of(manuel, paula, manuela));*/

//        User valentina = new User("2", "VALENTINA", LocalDateTime.now());
//        User paula = new User("3", "PAULA", LocalDateTime.now());
//
//
//        userRepository.save(valentina);
//        userRepository.save(paula);
//
//        for (User u : userRepository.findAll()) {
//            System.out.println(u);
//        }
//
//        manuel.setStatus(UserStatus.ACTIVE);
//        manuel.setName("EMMANUEL");
//        userRepository.save(manuel);
//
//        paula.setStatus(UserStatus.LOCK);
//        userRepository.save(paula);
//
//        for (User u : userRepository.findAll()) {
//            System.out.println(u);
//        }
//
//        userRepository.delete(valentina);
//
//        for (User u : userRepository.findAll()) {
//            System.out.println(u);
//        }
//
//        User vale = userRepository.findById("3").get();
//        System.out.println(vale);
//
//        User pau = userRepository.findByNameNative("PAULA");
//        System.out.println("Native: " + pau);
//
//        User pau3 = userRepository.findByName("PAULA");
//        System.out.println("Without query: " + pau3);
//
//        System.out.println("----------------------------------------");
//        userService.listAllUsersActive().forEach(System.out::println);
    }
}
