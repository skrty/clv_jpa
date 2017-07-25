package hello.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by skrty on 25.7.2017.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("s_p_z")
    private String spz;
    @JsonIgnore
    private String vinCode;
    @Enumerated(EnumType.STRING)
    private Color color;
    @Enumerated(EnumType.STRING)
    private CarManufacturer manufacturer;
    @ManyToOne
    private Customer customer;

    public Car() {
    }

    public Car(String spz, String vinCode, Color color, CarManufacturer manufacturer) {
        this.spz = spz;
        this.vinCode = vinCode;
        this.color = color;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public CarManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CarManufacturer manufacturer) {
        this.manufacturer = manufacturer;
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
                ", vinCode='" + vinCode + '\'' +
                ", color=" + color +
                ", manufacturer=" + manufacturer +
                ", customer=" + customer +
                '}';
    }
}
