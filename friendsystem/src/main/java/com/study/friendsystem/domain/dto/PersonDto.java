package com.study.friendsystem.domain.dto;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Embedded;
import javax.validation.Valid;
import java.time.LocalDate;

@Data
public class PersonDto {
    private String name;
    private int age;
    private String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private String job;
    private String phoneNumber;

}
