package br.com.erudio.person;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockPerson {


    public static Person mockEntity() {
        return mockEntity(0);
    }

    public static PersonVO mockVO() {
        return mockVO(0);
    }

    public static PersonVOV2 mockVOV2() {
        return mockVOV2(0);
    }


    public static List<Person> mockEntityList() {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public static List<PersonVO> mockVOList() {
        List<PersonVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    public static Person mockEntity(Integer number) {
        Person person = new Person();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setId(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public static PersonVO mockVO(Integer number) {
        PersonVO person = new PersonVO();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setLastName("Last Name Test" + number);
        return person;
    }

    public static PersonVOV2 mockVOV2(Integer number) {
        PersonVOV2 person = new PersonVOV2();
        person.setAddress("Address Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2) == 0) ? "Male" : "Female");
        person.setKey(number.longValue());
        person.setLastName("Last Name Test" + number);
        person.setBirthDay(new Date());
        return person;
    }

}
