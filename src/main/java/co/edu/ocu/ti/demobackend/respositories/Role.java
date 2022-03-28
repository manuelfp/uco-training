package co.edu.ocu.ti.demobackend.respositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class Role {

    @Id
    private String id;
    @Column(unique = true, nullable = false)
    private String role;
    private String description;

}
