package co.edu.ocu.ti.demobackend.services;

import co.edu.ocu.ti.demobackend.respositories.Role;
import co.edu.ocu.ti.demobackend.respositories.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> listAllUsers();

    User update(User user);

    List<User> listAllUsersActive();

    List<User> listAllUserByRole(String role);

}
