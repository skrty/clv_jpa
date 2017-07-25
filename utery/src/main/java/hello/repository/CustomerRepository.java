package hello.repository;

import hello.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skrty on 25.7.2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Iterable<Customer> findAllByLastname(String lastname);
    Iterable<Customer> findFirst2ByOrderByDiscountDesc();

    @Query("SELECT c FROM Customer c WHERE c.id > ?1")
    Iterable<Customer> doMagic(Long id);
}
