package my.rodo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Person extends BaseUpdateCreate{
    private String firstName;
    private String lastName;
    private String address;
    private Date birdDate;

    public Date getBirdDate() {
        return birdDate;
    }

    public void setBirdDate(Date birdDate) {
        this.birdDate = birdDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
