package br.com.erudio.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());


    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {
        logger.info("Finding everyone!");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return DozerMapper.parseObject(entity, null);
    }

    public PersonVO createPerson(PersonVO personVO) {
        logger.info("Creating one person!");

        var entity = DozerMapper.parseObject(personVO, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("updating person!");
        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }

    public void deletePerson(Long id) {
        logger.info("deleting one person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);

    }

}
