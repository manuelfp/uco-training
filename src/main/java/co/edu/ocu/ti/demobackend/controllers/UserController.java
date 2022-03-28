package co.edu.ocu.ti.demobackend.controllers;

import co.edu.ocu.ti.demobackend.respositories.Role;
import co.edu.ocu.ti.demobackend.respositories.User;
import co.edu.ocu.ti.demobackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> listAllUser() {
        return ResponseEntity.ok(userService.listAllUsers());
    }

    @GetMapping("/actives")
    public ResponseEntity<List<User>> listAllUserActive() {
        return ResponseEntity.ok(userService.listAllUsersActive());
    }

    @GetMapping("/{role}")
    public ResponseEntity<List<User>> listAllUserByRole(@PathVariable String role) {
        return ResponseEntity.ok(userService.listAllUserByRole(role));
    }
}
