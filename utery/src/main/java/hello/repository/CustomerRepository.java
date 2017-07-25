package hello.repository;

import hello.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skrty on 25.7.2017.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
