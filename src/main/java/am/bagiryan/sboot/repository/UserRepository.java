package am.bagiryan.sboot.repository;

import am.bagiryan.sboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsernameAndPassword(String username, String password);
    User getByUsername(String username);
    Boolean existsByUsername(String username);

//    @Query(nativeQuery = true, value = ("select * from user where username=:paramUsername"))
//    User getByUsername(@Param("paramUsername") String username);

}
