package br.com.erudio.controllers;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonService services;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return this.services.findAll();
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id
    ) {
        return this.services.findById(id);
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(@RequestBody PersonVO personVO
    ) {
        return this.services.createPerson(personVO);
    }

    @PostMapping(
            value = "/v2",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2
    ) {
        return this.services.createPersonV2(personVOV2);
    }

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO updatePerson(@RequestBody PersonVO personVO
    ) {
        return this.services.updatePerson(personVO);
    }

    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id
    ) {
        this.services.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
