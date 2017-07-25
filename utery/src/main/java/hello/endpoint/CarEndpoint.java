package hello.endpoint;

import hello.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Created by skrty on 25.7.2017.
 */
@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE = "http://spring.io/guides/gs-producing-web-service";

    private final CarRepository carRepository;

    @Autowired
    public CarEndpoint(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
