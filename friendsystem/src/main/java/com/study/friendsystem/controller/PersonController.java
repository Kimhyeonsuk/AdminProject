package com.study.friendsystem.controller;

import com.study.friendsystem.domain.Person;
import com.study.friendsystem.domain.dto.PersonDto;
import com.study.friendsystem.repository.PersonRepository;
import com.study.friendsystem.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/person")
@RestController
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    @RequestMapping(value="/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postPerson(@RequestBody Person person){
        personService.put(person);
    }

    @PutMapping("/{id}")
    public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        personService.modify(id,personDto);
    }

    @PatchMapping("/{id}")
    public void modifiyPerson(@PathVariable Long id,String name){
        personService.modify(id,name);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.delete(id);
        log.info("person->{}",personRepository.findAll());
    }
}
