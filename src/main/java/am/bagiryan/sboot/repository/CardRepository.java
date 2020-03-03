package am.bagiryan.sboot.repository;

import am.bagiryan.sboot.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card getByOwnerName(String ownerName);

    Card getByNumber(String number);

    Boolean existsByNumber(String number);

    Boolean existsByOwnerName(String ownerName);

    Card getById(long id);

    boolean existsByNumberAndIdNot(String number, long id);

    @Modifying
    void deleteByNumber(String number);

}
