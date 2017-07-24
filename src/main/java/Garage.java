import entity.Car;
import entity.CarBrand;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by skrty on 24.7.2017.
 */
public class Garage {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        System.out.println("Program started!");

        emf = Persistence.createEntityManagerFactory("garage.jpa");
        em = emf.createEntityManager();

        //začátek transakce
        em.getTransaction().begin();

        Car car = new Car("123 ZXA", "blue", "Czech Republic", 120000L, CarBrand.SKODA);
        em.persist(car);

        Customer customer = new Customer("Ondřej", "Škrdlant", "ondrej.skrdlant@cleverlance.com", "123 456 789", 0);
        Customer customer2 = new Customer("Honza", "Škrdlant", "honza.skrdlant@cleverlance.com", "123 456 790", 10);

        em.persist(customer);
        em.persist(customer2);

        // commit změn
        em.getTransaction().commit();

        fetching();

        em.close();
        emf.close();
    }

    private static void fetching() {
        em.getTransaction().begin();

        Customer bohaty_zakaznik = new Customer("Ondřej", "Škrdlant", "ondrej.skrdlant@cleverlance.com", "123 456 789", 0);
        bohaty_zakaznik.getCars().add(new Car("Auto1"));
        bohaty_zakaznik.getCars().add(new Car("Auto2"));
        bohaty_zakaznik.getCars().add(new Car("Auto3"));
        bohaty_zakaznik.getCars().add(new Car("Auto4"));

        em.persist(bohaty_zakaznik);

        em.getTransaction().commit();
    }
}
