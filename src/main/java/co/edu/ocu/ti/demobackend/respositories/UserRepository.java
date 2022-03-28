package co.edu.ocu.ti.demobackend.respositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from users u where u.name = :name")
    User findByName2(String name);

    @Query(value = "select u.* from users u where u.full_name = ?1", nativeQuery = true)
    User findByNameNative(String name);

    User findByName(String name);

    List<User> findAllByRole(Role role);
}
