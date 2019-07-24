package wsiz.groupproject.demo.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    @Transient
    private String passwordConfirm;
//    @ManyToMany
//    private Set<Role> roles;
    private boolean isLogged = false;
//    private Order basket;
    //    @Email
    private String email;


}
