package com.study.friendsystem.repository;

import com.study.friendsystem.domain.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Test
    void crud(){
        Person person=new Person();
        person.setName("martin");
        person.setAge(29);
        person.setBloodType("A");
        personRepository.save(person);

        //System.out.println(personRepository.findAll());
        //객체의 해시값이 출력된다.=> tostring 메소드를 overriding 해야함
        List<Person> people=personRepository.findAll();
        Assertions.assertEquals(people.size(),1);
        Assertions.assertEquals(people.get(0).getName(),"martin");
        Assertions.assertEquals(people.get(0).getAge(),29);
        Assertions.assertEquals(people.get(0).getBloodType(),"A");
    }

    @Test
    void hashCodeAndEquals(){
        Person person1=new Person("martin",10,"A");
        Person person2=new Person("martin",10,"A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person,Integer> map=new HashMap<>();
        map.put(person1,person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));
    }
}