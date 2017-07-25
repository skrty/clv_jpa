package hello.repository;

import hello.entity.Car;
import hello.entity.CarManufacturer;
import hello.entity.Color;
import hello.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skrty on 25.7.2017.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.customer = ?1 AND (c.color = ?2 OR c.manufacturer = ?3)")
    Iterable<Car> findAllByCustomerAndColorOrManufacturer(Customer customer, Color color, CarManufacturer manufacturer);
}
