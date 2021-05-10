package com.study.friendsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode//객체의 값에 따라 해쉬코드가 결정된다
@ToString(exclude = "phoneNumber")
public class Person {
    @Id
    @GeneratedValue//값을 자동으로 생성
    private Long id;

    @NonNull//requriedargument에 필요한 인자들
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;

    private LocalDate birthday;

    private String job;

    private String phoneNumber;

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
}
