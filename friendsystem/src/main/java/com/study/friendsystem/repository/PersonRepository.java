package com.study.friendsystem.repository;

import com.study.friendsystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByName(String name);

    List<Person>findByBlockNull();

    List<Person> findByBloodType(String bloodType);

    @Query(value="select person from Person person where person.birthday.monthOfBirthday=:monthOfBirthday and person.birthday.dayOfBirthday=:dayOfBirthday")//?1 은 함수에서 첫번째 인자(monthOfBirthday)
    //@Query(value="select * from person where month_of_birthday=:monthOfBirthday",nativeQuery = true)
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday")int monthOfBirthday,@Param("dayOfBirthday") int dayOfBirthday);

    @Query(value="select person from Person person where person.deleted=true",nativeQuery = true)
    List<Person> findPeopleDeleted();
}
