package am.bagiryan.sboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Component
@Table(name = "user", schema = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;

    private String name;
    private String surname;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private int age;
    private String code;
    private int status;

}
