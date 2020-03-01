package am.bagiryan.sboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Component
@Table(name = "user", schema = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;

    @NotBlank
    private String name;
    @NotBlank
    private String surname;

    @Email
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Size(max = 99)
    private int age;
    @NotBlank
    private String code;

    @Enumerated
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

}
