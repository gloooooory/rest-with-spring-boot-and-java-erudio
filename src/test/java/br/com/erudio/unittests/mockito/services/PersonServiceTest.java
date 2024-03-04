package br.com.erudio.unittests.mockito.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.model.Person;
import br.com.erudio.person.MockPerson;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    PersonRepository repository;
    @InjectMocks
    private PersonService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        List<Person> list = MockPerson.mockEntityList();

        when(repository.findAll()).thenReturn(list);

        var persons = service.findAll();

        assertNotNull(persons);
        assertEquals("", 14, persons.size());

        var personOne = persons.get(1);

        assertNotNull(personOne);
        assertNotNull(personOne.getKey());
        assertNotNull(personOne.getLinks());

        assertTrue(personOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("expect to return a address", "Address Test1", personOne.getAddress());
        assertEquals("expect to return a first name", "First Name Test1", personOne.getFirstName());
        assertEquals("expect to return a last name", "Last Name Test1", personOne.getLastName());
        assertEquals("expect to return a gender", "Female", personOne.getGender());

        var personFour = persons.get(4);

        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertNotNull(personFour.getLinks());

        assertTrue(personFour.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));

        assertEquals("expect to return a address", "Address Test4", personFour.getAddress());
        assertEquals("expect to return a first name", "First Name Test4", personFour.getFirstName());
        assertEquals("expect to return a last name", "Last Name Test4", personFour.getLastName());
        assertEquals("expect to return a gender", "Male", personFour.getGender());

        var personSeven = persons.get(7);

        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertNotNull(personSeven.getLinks());

        assertTrue(personSeven.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));

        assertEquals("expect to return a address", "Address Test7", personSeven.getAddress());
        assertEquals("expect to return a first name", "First Name Test7", personSeven.getFirstName());
        assertEquals("expect to return a last name", "Last Name Test7", personSeven.getLastName());
        assertEquals("expect to return a gender", "Female", personSeven.getGender());
    }

    @Test
    void findById() {
        Person entity = MockPerson.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("expect to return a address", "Address Test1", result.getAddress());
        assertEquals("expect to return a first name", "First Name Test1", result.getFirstName());
        assertEquals("expect to return a last name", "Last Name Test1", result.getLastName());
        assertEquals("expect to return a gender", "Female", result.getGender());
    }

    @Test
    void createPerson() {
        Person entity = MockPerson.mockEntity(1);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = MockPerson.mockVO(1);
        vo.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(entity)).thenReturn(persisted);


        var result = service.updatePerson(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("expect to return a address", "Address Test1", result.getAddress());
        assertEquals("expect to return a first name", "First Name Test1", result.getFirstName());
        assertEquals("expect to return a last name", "Last Name Test1", result.getLastName());
        assertEquals("expect to return a gender", "Female", result.getGender());
    }

    @Test
    void createPersonWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.createPerson(null);
        });

        final String expectMessage = "It is not allowed to persist a null object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectMessage));

    }

    @Test
    void updatePerson() {
        Person entity = MockPerson.mockEntity(1);
        entity.setId(1L);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = MockPerson.mockVO(1);
        vo.setKey(1L);

        when(repository.save(entity)).thenReturn(persisted);

        var result = service.createPerson(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("expect to return a address", "Address Test1", result.getAddress());
        assertEquals("expect to return a first name", "First Name Test1", result.getFirstName());
        assertEquals("expect to return a last name", "Last Name Test1", result.getLastName());
        assertEquals("expect to return a gender", "Female", result.getGender());
    }

    @Test
    void updatePersonWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            service.updatePerson(null);
        });

        final String expectMessage = "It is not allowed to persist a null object";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectMessage));

    }

    @Test
    void deletePerson() {
        Person entity = MockPerson.mockEntity(1);
        entity.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));

        service.deletePerson(1L);
    }
}