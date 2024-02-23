package br.com.erudio.services;

import model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private static final AtomicLong counter = new AtomicLong();
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Finding everyone!");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Jose");
        person.setLastName("Costa");
        person.setAddress("Xique Xique - Bahia");
        person.setGender("Non Binarie");
        return person;
    }

    public Person createPerson(Person person) {
        logger.info("Creating one person!");
        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("updating person!");
        return person;
    }

    public void deletePerson(String id) {
        logger.info("deleting one person!");
    }

    private static Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name" + i);
        person.setAddress("Some Address in Brazil" + i);
        person.setGender("Non Binarie");
        return person;
    }

}
