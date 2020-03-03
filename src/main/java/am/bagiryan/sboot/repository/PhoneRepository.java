package am.bagiryan.sboot.repository;

import am.bagiryan.sboot.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    Phone getById(long id);
    Boolean existsById(long id);
}
