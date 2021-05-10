package com.study.friendsystem.service;

import com.study.friendsystem.domain.Block;
import com.study.friendsystem.domain.Person;
import com.study.friendsystem.repository.BlockReposiroty;
import com.study.friendsystem.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {
    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockReposiroty blockReposiroty;

    @Test
    void getPeopleExcludeBlocks(){
        givePeople();
        //giveBlocks();

        List<Person> result=personService.getPeopleExcludeBlocks();

        //System.out.println(result);
        result.forEach(System.out::println);//stream과 동일
    }
    @Test
    void cascasdeTest(){
        givePeople();

        List<Person>result=personRepository.findAll();
        result.forEach(System.out::println);


        Person person=result.get(3);
        person.getBlock().setEndDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);


        /*personRepository.delete(person);
        personRepository.findAll().forEach(System.out::println);
        blockReposiroty.findAll().forEach(System.out::println);*/

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockReposiroty.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson(){
        givePeople();

        Person person=personService.getPerson(3L);

        System.out.println(person);
    }
    private void giveBlocks() {
        givenBlock("martin");
    }

    private Block givenBlock(String name) {
        return blockReposiroty.save(new Block("martin"));
    }

    private void givePeople() {
        givePerson("martin",10,"A");
        givePerson("david",9,"B");
        givenBlockPerson("dennis",7,"O");
        givenBlockPerson("martin",11,"AB");
    }

    private void givePerson(String name, int age, String bloodType) {
        personRepository.save(
                new Person(name,age,bloodType)
        );
    }

    private void givenBlockPerson(String name,int age,String bloodType){
        Person blockPerson=new Person(name,age,bloodType);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);

    }
}