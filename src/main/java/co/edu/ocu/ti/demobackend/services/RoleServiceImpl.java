package co.edu.ocu.ti.demobackend.services;

import co.edu.ocu.ti.demobackend.respositories.Role;
import co.edu.ocu.ti.demobackend.respositories.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        try{
            String id = UUID.randomUUID().toString();
            role.setId(id);
           return roleRepository.save(role);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findRoleByName(String role) {
        return roleRepository.findByRole(role);
    }
}
