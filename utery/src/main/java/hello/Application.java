package hello;

import hello.entity.Car;
import hello.entity.CarManufacturer;
import hello.entity.Color;
import hello.entity.Customer;
import hello.repository.CarRepository;
import hello.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * Created by skrty on 25.7.2017.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    public CommandLineRunner demo(CarRepository carRepository, CustomerRepository customerRepository) {
        CommandLineRunner runner = new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                System.out.println("Ahoj světe!");

                customerRepository.save(
                        new Customer("Ondřej", "Škrdlant", 82, "ondrej.skrdlant@cleverlance.com", "123-456-789"));
                customerRepository.save(
                        new Customer("Jan", "Novák", 10, "jan.novak@cleverlance.com", "456-754-156"));
                customerRepository.save(
                        new Customer("Josef", "Novák", 90, "josef@novak.com", "654-741-123"));

                Iterable<Customer> customers = customerRepository.findAll();
                for(Customer c : customers) {
                    System.out.println(c);
                }

                System.out.println("Jen Novákovi!");
                Iterable<Customer> novakovi = customerRepository.findAllByLastname("Novák");
                for(Customer c : novakovi) {
                    System.out.println(c);
                }

                System.out.println("By discount!");
                Iterable<Customer> topDiscounts = customerRepository.findFirst2ByOrderByDiscountDesc();
                for(Customer c : topDiscounts) {
                    System.out.println(c);
                }

                System.out.println("Bigger id!");
                Iterable<Customer> bigIds = customerRepository.doMagic(1L);
                for(Customer c : bigIds) {
                    System.out.println(c);
                }

                Customer c = new Customer("Ondřej", "Škrdlant", 40, "ondrej.skrdlant2@cleverlance.com", "123-456-789");
                Random random = new Random();
                for (int i = 0; i < 100; i++) {
                    Color color = null;
                    switch (random.nextInt(4)) {
                        case 0:
                            color = Color.BLACK;
                            break;
                        case 1:
                            color = Color.GREEN;
                            break;
                        case 2:
                            color = Color.WHITE;
                            break;
                        case 3:
                            color = Color.RED;
                            break;
                    }

                    CarManufacturer manufacturer = null;
                    switch (random.nextInt(4)) {
                        case 0:
                            manufacturer = CarManufacturer.SKODA;
                            break;
                        case 1:
                            manufacturer = CarManufacturer.TESLA;
                            break;
                        case 2:
                            manufacturer = CarManufacturer.VW;
                            break;
                        case 3:
                            manufacturer = CarManufacturer.VOLVO;
                            break;
                    }
                    Car car = new Car("SPZ" + i, "VIN" + i, color, manufacturer);
                    car.setCustomer(c);
                    c.getCars().add(car);
                }
                //uložím customera a přes kaskádu auta
                customerRepository.save(c);

                System.out.println(carRepository.count());

                Iterable<Car> myBlackOrTeslas = carRepository.findAllByCustomerAndColorOrManufacturer(c, Color.BLACK, CarManufacturer.TESLA);
                for(Car myCar : myBlackOrTeslas) {
                    System.out.println(myCar);
                }

                System.out.println("Sbohem světe!");
            }
        };
        return runner;
    }
}
