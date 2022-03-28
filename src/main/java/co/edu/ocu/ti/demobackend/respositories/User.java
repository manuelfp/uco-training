package co.edu.ocu.ti.demobackend.respositories;

import co.edu.ocu.ti.demobackend.models.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    private String id;
    @Column(name = "full_name", length = 1042, unique = true)
    private String name;
    private LocalDateTime age;
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.INACTIVE;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Role> role;

    public User(String id, String name, LocalDateTime age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
