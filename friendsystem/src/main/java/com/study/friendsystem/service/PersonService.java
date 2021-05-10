package com.study.friendsystem.service;

import com.study.friendsystem.domain.Block;
import com.study.friendsystem.domain.Person;
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
        List<Person>people =personRepository.findAll();
        List<Block>blocks=blockReposiroty.findAll();
      /*  List<String>blockNames=
                blocks.stream()
                .map(Block::getName).collect(Collectors.toList());*/
       /* return people.stream().filter(
                person -> !blockNames.contains(person.getName())
        ).collect(Collectors.toList());*/

        return people.stream().filter(
                person -> person.getBlock()!=null
        ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        Person person=personRepository.findById(id).get();
        //System.out.println("person : "+person);
        log.info("person : {}", person);//배포가 됬을때 log 출력을 제한하수 있다.
        //production코드에선 log 활용하느느 것이 좋다.
        return person;
    }
}
