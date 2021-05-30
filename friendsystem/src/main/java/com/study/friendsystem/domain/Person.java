package com.study.friendsystem.domain;

import com.study.friendsystem.domain.dto.Birthday;
import com.study.friendsystem.domain.dto.PersonDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode//객체의 값에 따라 해쉬코드가 결정된다
@ToString(exclude = "phoneNumber")
@Where(clause = "deleted = false")//delete가 false인 내용 제외
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//값을 자동으로 생성
    private Long id;

    @NonNull//requriedargument에 필요한 인자들
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;

    private String hobby;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;

    private String address;

    @Embedded
    @Valid
    @NonNull
    private Birthday birthday;

    private String job;

    private String phoneNumber;

    @ColumnDefault("0")
    private boolean deleted;
    //@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    //@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    private Block block;


    /*public boolean equals(Object object){
        if(object==null){
            return false;
        }

        Person person=(Person)object;
        if(!person.getName().equals(this.getName())){
            return false;
        }

        if(person.getAge()!=this.getAge()){
            return false;
        }

        return true;
    }

    public int hashCode(){//서로다른 객체일지라도 같은 해쉬코드로 바꾸어 준다.=>
        // db에서 가져온 값이 동일하게 사용되려면 동일한 해쉬코드로 바꾸어 주어야함
        //객체에 필드가 추가될때마다 실수를 최소화 할 수 있다.
        return (name+age+bloodType).hashCode();
    }*/
    public void set(PersonDto personDto){
        if(personDto.getAge()!=0){
            this.setAge(personDto.getAge());
        }
        if(!StringUtils.isEmpty(personDto.getHobby())){
            this.setHobby(personDto.getHobby());
        }
        if(!StringUtils.isEmpty(personDto.getBloodType())){
            this.setBloodType(personDto.getBloodType());
        }
        if(!StringUtils.isEmpty(personDto.getAddress())){
            this.setAddress(personDto.getAddress());
        }
        if(!StringUtils.isEmpty(personDto.getJob())){
            this.setJob(personDto.getJob());
        }
        if(!StringUtils.isEmpty(personDto.getPhoneNumber())){
            this.setPhoneNumber(personDto.getPhoneNumber());
        }
    }
}
