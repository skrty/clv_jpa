import entity.Car;
import entity.CarBrand;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by skrty on 24.7.2017.
 */
public class Garage {
    public static void main(String[] args) {
        System.out.println("Program started!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("garage.jpa");
        EntityManager em = emf.createEntityManager();

        //začátek transakce
        em.getTransaction().begin();

        Car car = new Car("123 ZXA", "blue", "Czech Republic", 120000L, CarBrand.SKODA);
        em.persist(car);

        // commit změn
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
