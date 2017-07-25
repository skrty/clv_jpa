import entity.Car;
import entity.CarBrand;
import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

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

        //newCustomer();
        /*fetching();
        printCars();
        List<Car> allCars = getAllCars();
        for(Car c : allCars) {
            System.out.println(c);
        }

        createCustomer(55);
        createCustomer(14);
        createCustomer(65);
        List<Customer> customersWithDiscount = getCustomersWithDiscount(50);
        System.out.println("Customers with disc: " + customersWithDiscount.size());
        */
        List<Customer> customers = getCustomersWithCars();
        for (Customer c : customers) {
            System.out.println(c);
        }

        //maintenance();
        em.close();
        emf.close();
    }

    private static Customer getCustomerWithTopDiscount() {
        Customer customer = null;
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT c FROM Customer c ORDER BY c.discount");
        q.setMaxResults(1);
        List<Customer> c = q.getResultList();
        em.getTransaction().commit();

        if (c == null || c.isEmpty()) {
            return null;
        } else {
            return c.get(0);
        }
    }

    private static List<Customer> getCustomersWithCars() {
        List<Customer> customers = null;

        em.getTransaction().begin();

        Query q = em.createQuery("SELECT cust FROM Customer cust join fetch cust.cars");
        customers= q.getResultList();

        em.getTransaction().commit();
        return customers;
    }

    private static void createCustomer(int i) {
        em.getTransaction().begin();

        em.persist(new Customer("Jan", "Novák", "jan@novak.cz", "123456789", i));

        em.getTransaction().commit();
    }

    private static List<Customer> getCustomersWithDiscount(int i) {
        List<Customer> customers = null;

        em.getTransaction().begin();

        Query q = em.createQuery("SELECT cust FROM Customer cust WHERE cust.discount > :disc");
        q.setParameter("disc", i);
        customers = q.getResultList();

        em.getTransaction().commit();

        return customers;
    }

    private static List<Car> getAllCars() {
        List<Car> cars = null;

        em.getTransaction().begin();

        Query q = em.createQuery("SELECT c FROM Car c");
        cars = (List<Car>)q.getResultList();

        em.getTransaction().commit();
        return cars;
    }

    private static void printCars() {
        em.getTransaction().begin();

        Query q = em.createQuery("SELECT c FROM Car c");
        List<Car> cars = (List<Car>)q.getResultList();
        for (Car c : cars) {
            System.out.println(c);
        }

        em.getTransaction().commit();
    }

    private static void maintenance() {
        em.getTransaction().begin();

        //em.persist();

        em.getTransaction().commit();
    }

    private static void newCustomer() {
        //začátek transakce
        em.getTransaction().begin();

        Car car = new Car("123 ZXA", "blue", "Czech Republic", 120000L, CarBrand.SKODA, null);
        em.persist(car);

        Customer customer = new Customer("Ondřej", "Škrdlant", "ondrej.skrdlant@cleverlance.com", "123 456 789", 0);
        Customer customer2 = new Customer("Honza", "Škrdlant", "honza.skrdlant@cleverlance.com", "123 456 790", 10);

        em.persist(customer);
        em.persist(customer2);

        // commit změn
        em.getTransaction().commit();
    }

    private static void fetching() {
        em.getTransaction().begin();

        //PERZIST
        Customer bohaty_zakaznik = new Customer("Ondřej", "Škrdlant", "ondrej.skrdlant@cleverlance.com", "123 456 789", 0);
        bohaty_zakaznik.getCars().add((new Car("Auto1", bohaty_zakaznik)));
        bohaty_zakaznik.getCars().add(new Car("Auto2", bohaty_zakaznik));
        bohaty_zakaznik.getCars().add(new Car("Auto3", bohaty_zakaznik));
        bohaty_zakaznik.getCars().add(new Car("Auto4", bohaty_zakaznik));

        em.persist(bohaty_zakaznik);
        System.out.println("------------");
        System.out.println("ID zakaznika: " + bohaty_zakaznik.getId());
        System.out.println("------------");

        em.getTransaction().commit();
    }
}
