package hello;

import hello.repository.CarRepository;
import hello.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by skrty on 25.7.2017.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(CarRepository carRepository, CustomerRepository customerRepository) {
        CommandLineRunner runner = new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Ahoj světe!");
            }
        };

        return runner;
    }

}
