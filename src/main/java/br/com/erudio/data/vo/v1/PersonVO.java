package br.com.erudio.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.dozer.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;


@JsonPropertyOrder({"id", "first_name", "last_name", "address", "gender",})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersionUID = 0L;
    @JsonProperty("id")
    @Mapping("id")
    private long key;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")

    private String lastName;
    private String address;
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PersonVO person = (PersonVO) o;
        return Objects.equals(this.getKey(), person.getKey()) && Objects.equals(this.getFirstName(), person.getFirstName()) && Objects.equals(this.getLastName(), person.getLastName()) && Objects.equals(this.getAddress(), person.getAddress()) && Objects.equals(this.getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getKey(), this.getFirstName(), this.getLastName(), this.getAddress(), this.getGender());
    }


    public long getKey() {
        return this.key;
    }

    public void setKey(long key) {
        this.key = key;
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
