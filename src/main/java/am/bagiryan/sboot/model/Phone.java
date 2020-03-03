package am.bagiryan.sboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "phone", schema = "test")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;

    private String model;
    private String vendor;
    private int memory;
}
