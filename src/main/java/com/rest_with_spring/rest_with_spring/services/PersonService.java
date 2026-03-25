package com.rest_with_spring.rest_with_spring.services;

import com.rest_with_spring.rest_with_spring.exceptions.NotFoundResourceException;
import com.rest_with_spring.rest_with_spring.models.Person;
import com.rest_with_spring.rest_with_spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding One Person");
        return personRepository.findById(id).orElseThrow(()-> new NotFoundResourceException("Nao encontrado"));
    }

    public Person create(Person person){
        logger.info("Pessoa criada");
        return personRepository.save(person);
    }

    public Person updatePerson(Person person){
        logger.info("Atualizando pessoa");
        Person entity = personRepository.findById(person.getId()).orElseThrow(()-> new NotFoundResourceException("Nao encontrado"));

        entity.setFirstName(person.getFirstName());
        entity.setLastname(person.getLastname());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return personRepository.save(entity);
    }

    public void deleteById(Long id){
        Person entity = personRepository.findById(id).orElseThrow(()-> new NotFoundResourceException("Nao encontrado"));
        personRepository.deleteById(id);
        logger.info("Deletando Usuario");
    }

}
