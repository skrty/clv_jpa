package hello.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by skrty on 25.7.2017.
 */
@Entity
@Table(name = "C_U_S_T_O_M_E_R")
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    private Integer discount;

    @Column(nullable = false, unique = true, name = "e_mail")
    private String email;

    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> cars;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Integer discount, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.discount = discount;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Car> getCars() {
        if (cars == null) {
            cars = new ArrayList<>();
        }
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
