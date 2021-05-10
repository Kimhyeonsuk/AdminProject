package com.study.friendsystem.repository;

import com.study.friendsystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
