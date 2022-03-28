package co.edu.ocu.ti.demobackend.services;

import co.edu.ocu.ti.demobackend.models.UserStatus;
import co.edu.ocu.ti.demobackend.respositories.Role;
import co.edu.ocu.ti.demobackend.respositories.User;
import co.edu.ocu.ti.demobackend.respositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsersActive() {
        return userRepository.findAll().stream()
                .filter(user -> user.getStatus().equals(UserStatus.ACTIVE))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> listAllUserByRole(String role) {
        Role roleByName = roleService.findRoleByName(role);
        if (roleByName == null)
            return new ArrayList<>();
        return userRepository.findAllByRole(roleByName);
    }

}
