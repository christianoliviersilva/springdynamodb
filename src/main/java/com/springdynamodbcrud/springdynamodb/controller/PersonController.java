package com.springdynamodbcrud.springdynamodb.controller;

import com.springdynamodbcrud.springdynamodb.entity.Person;
import com.springdynamodbcrud.springdynamodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Person save(@RequestBody Person person) {

        return personRepository.save(person);
    }
    @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") String id) {
        return personRepository.findById(id);
    }
    @GetMapping
    public List<Person> findAll() {

        return personRepository.findAll();
    }
    @PutMapping("/{id}")
    public Person updated(@PathVariable(value = "id") String id, @RequestBody Person person) {
         return personRepository.update(id, person);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") String id,
                         @PathVariable(value = "firstName") String firstName) {
        return personRepository.delete(id, firstName);
    }
}
