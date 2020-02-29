package am.bagiryan.sboot.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Component
@Table(name = "card", schema = "test")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;

    private String ownerName;
    private String number;
    private int cvv;

}
