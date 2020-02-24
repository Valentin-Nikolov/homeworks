package spotify.jpa.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spotify.jpa.entities.Customer;

import java.util.Date;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Transactional
    @Modifying
    @Query(value = "update customers set first_name = :first_name, " +
            "last_name = :last_name, " +
            "email = :email, " +
            "date_of_birth = :date_of_birth, " +
            "is_payed = :is_payed " +
            "WHERE id = :id", nativeQuery = true)
    void updateCustomer(@Param("id") Long id,
                         @Param("first_name") String first_name,
                         @Param("last_name") String last_name,
                         @Param("email") String email,
                         @Param("date_of_birth") Date date_of_birth,
                         @Param("is_payed") boolean is_payed);
}