package com.study.friendsystem.service;

import com.study.friendsystem.domain.Block;
import com.study.friendsystem.domain.Person;
import com.study.friendsystem.domain.dto.Birthday;
import com.study.friendsystem.repository.BlockReposiroty;
import com.study.friendsystem.repository.PersonRepository;
import org.apache.tomcat.jni.Local;
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
        //givePeople();
        //giveBlocks();

        List<Person> result=personService.getPeopleExcludeBlocks();

        //System.out.println(result);
        result.forEach(System.out::println);//stream과 동일
    }
    @Test
    void getPeopleByName(){
        //givePeople();
        List<Person>result=personService.getPeopleByName("martin");
        result.forEach(System.out::println);
    }
    @Test
    void findByBloodType(){
        //givePeople();
        List<Person> result=personRepository.findByBloodType("A");
        result.forEach(System.out::println);

    }

    @Test
    void findByBirthday(){
        //givePeople();
        List<Person> result=personRepository.findByMonthOfBirthday(8,21);
        result.forEach(System.out::println);
    }
    @Test
    void cascasdeTest(){
        //givePeople();

//        List<Person>result=personRepository.findAll();
//        result.forEach(System.out::println);
//
//
//        Person person=result.get(3);
//        person.getBlock().setEndDate(LocalDate.now());
//        person.getBlock().setEndDate(LocalDate.now());
//
//        personRepository.save(person);
//        personRepository.findAll().forEach(System.out::println);
//
//
//        /*personRepository.delete(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockReposiroty.findAll().forEach(System.out::println);*/
//
//        person.setBlock(null);
//        personRepository.save(person);
//        personRepository.findAll().forEach(System.out::println);
//        blockReposiroty.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson(){
        //givePeople();

        //Person person=personService.getPerson(1L);

        //System.out.println(person);
    }
    private void giveBlocks() {
        givenBlock("martin");
    }

    private Block givenBlock(String name) {
        return blockReposiroty.save(new Block("martin"));
    }

    private void givePeople() {
        givePerson("martin",10,"A",LocalDate.of(1991,8,15));
        givePerson("david",9,"B",LocalDate.of(1991,8,20));
        givenBlockPerson("dennis",7,"O");
        givenBlockPerson("martin",11,"AB");
    }

    private void givePerson(String name, int age, String bloodType, LocalDate birthday) {
//        Person person =new Person(name,age,bloodType);
//        person.setBirthday(new Birthday(birthday.getYear(),birthday.getMonthValue(),birthday.getDayOfMonth()));
//        personRepository.save(
//                person
//        );
    }

    private void givenBlockPerson(String name,int age,String bloodType){
//        Person blockPerson=new Person(name,age,bloodType);
//        blockPerson.setBirthday(new Birthday(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth()));
//        blockPerson.setBlock(new Block(name));
//        personRepository.save(blockPerson);

    }
}