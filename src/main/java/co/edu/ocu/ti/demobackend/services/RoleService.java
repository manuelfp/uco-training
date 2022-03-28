package co.edu.ocu.ti.demobackend.services;


import co.edu.ocu.ti.demobackend.respositories.Role;

import java.util.List;

public interface RoleService {

    Role create(Role role);

    List<Role> listRoles();

    Role findRoleByName(String role);
}
