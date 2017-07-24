package entity;

import javax.persistence.*;

/**
 * Created by skrty on 24.7.2017.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String spz;

    private String color;

    private String origin;

    private Long kilometers;

    private String name;

    @Enumerated(EnumType.STRING)
    private CarBrand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Car () {
    }

    public Car(String name, Customer owner) {
        this.customer = owner;
        this.name = name;
    }

    public Car (String spz, String color, String origin, Long kilometers, CarBrand brand, Customer owner) {
        this.spz = spz;
        this.color = color;
        this.origin = origin;
        this.kilometers = kilometers;
        this.brand = brand;
        this.customer = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getKilometers() {
        return kilometers;
    }

    public void setKilometers(Long kilometers) {
        this.kilometers = kilometers;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", spz='" + spz + '\'' +
                ", customer=" + customer +
                '}';
    }
}
