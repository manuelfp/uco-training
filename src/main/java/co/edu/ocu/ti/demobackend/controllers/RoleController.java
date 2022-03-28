package co.edu.ocu.ti.demobackend.controllers;

import co.edu.ocu.ti.demobackend.respositories.Role;
import co.edu.ocu.ti.demobackend.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createRole(@RequestBody Role role){
        Role response = roleService.create(role);
        if(response == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Role>> listRoles(){
        return ResponseEntity.ok(roleService.listRoles());
    }

}
