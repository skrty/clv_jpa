package entity;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

/**
 * Created by skrty on 24.7.2017.
 */
@Entity
public class Maintenance {
    @Id
    @GeneratedValue
    private long id;
    private int cost;
    private DateTime accepted;
    private MaintenanceStatus status;
    private DateTime returned;
    @OneToOne
    private Car car;

    @ManyToMany
    private List<Mechanic> mechanics;

    public Maintenance() {
    }

    public Maintenance(int cost, DateTime accepted, MaintenanceStatus status, DateTime returned) {
        this.cost = cost;
        this.accepted = accepted;
        this.status = status;
        this.returned = returned;
    }

    public long getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public DateTime getAccepted() {
        return accepted;
    }

    public void setAccepted(DateTime accepted) {
        this.accepted = accepted;
    }

    public MaintenanceStatus getStatus() {
        return status;
    }

    public void setStatus(MaintenanceStatus status) {
        this.status = status;
    }

    public DateTime getReturned() {
        return returned;
    }

    public void setReturned(DateTime returned) {
        this.returned = returned;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
