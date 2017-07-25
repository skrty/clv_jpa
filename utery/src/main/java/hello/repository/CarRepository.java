package hello.repository;

import hello.entity.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by skrty on 25.7.2017.
 */
public interface CarRepository extends CrudRepository<Car, Long> {
}
