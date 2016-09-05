package evoliris.com.hamid_sqlite.model;

import java.util.Date;

/**
 * Created by temp on 29/08/2016.
 */
public class User {

    private long id;
    private String name;
    private Date dob;
    private float salary;
    private boolean favourite;

    public User() {
    }

    public User(String name, Date dob, float salary, boolean favourite) {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.favourite = favourite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
