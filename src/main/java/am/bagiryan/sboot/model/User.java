package am.bagiryan.sboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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
    private String username;
    private String password;
    private int age;
    private int code;
    private int status;

}
