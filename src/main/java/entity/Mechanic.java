package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by skrty on 24.7.2017.
 */
@Entity
public class Mechanic {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private int skill;
    private int wage;

    public Mechanic(){};

    public Mechanic(String firstname, String lastname, int skill, int wage) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.skill = skill;
        this.wage = wage;
    }

    public long getId() {
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

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }
}
