package com.study.friendsystem.service;

import com.study.friendsystem.domain.Block;
import com.study.friendsystem.domain.Person;
import com.study.friendsystem.domain.dto.Birthday;
import com.study.friendsystem.domain.dto.PersonDto;
import com.study.friendsystem.repository.BlockReposiroty;
import com.study.friendsystem.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockReposiroty blockReposiroty;

    public List<Person> getPeopleExcludeBlocks(){
//        List<Person>people =personRepository.findAll();
//        List<Block>blocks=blockReposiroty.findAll();
      /*  List<String>blockNames=
                blocks.stream()
                .map(Block::getName).collect(Collectors.toList());*/
       /* return people.stream().filter(
                person -> !blockNames.contains(person.getName())
        ).collect(Collectors.toList());*/

//        return people.stream().filter(
//                person -> person.getBlock()!=null
//        ).collect(Collectors.toList());

        return personRepository.findByBlockNull();
    }
    public List<Person> getPeopleByName(String name){
//        List<Person> people=personRepository.findAll();
//        return people.stream().filter(person -> person.getName().equals(name))
//                .collect(Collectors.toList());
        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        //Person person=personRepository.findById(id).get();
        Person person=personRepository.findById(id).orElse(null);

        //System.out.println("person : "+person);
        log.info("person : {}", person);//배포가 됬을때 log 출력을 제한하수 있다.
        //production코드에선 log 활용하느느 것이 좋다.
        return person;
    }

    @Transactional
    public void put(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, PersonDto personDto) {
        Person person=personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지않습니다."));

        if(!person.getName().equals(personDto.getName())){
            throw new RuntimeException("이름이 다릅니다.");
        }
        person.set(personDto);

        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, String name){
        Person person=personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지않습니다."));
        person.setName(name);
        personRepository.save(person);
    }

    @Transactional
    public void delete(Long id) {
//        Person person=personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지않습니다."));
//        personRepository.delete(person);
        //personRepository.deleteById(id);

        Person person=personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지않습니다."));
        person.setDeleted(true);
        personRepository.save(person);
    }
}
