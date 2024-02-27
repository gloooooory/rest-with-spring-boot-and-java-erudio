package br.com.erudio.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;


public class PersonVO implements Serializable {

    private static final long serialVersionUID = 0L;
    private long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PersonVO person = (PersonVO) o;
        return Objects.equals(this.getId(), person.getId()) && Objects.equals(this.getFirstName(), person.getFirstName()) && Objects.equals(this.getLastName(), person.getLastName()) && Objects.equals(this.getAddress(), person.getAddress()) && Objects.equals(this.getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getFirstName(), this.getLastName(), this.getAddress(), this.getGender());
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
