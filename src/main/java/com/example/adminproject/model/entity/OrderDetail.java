package com.example.adminproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity//order_detail
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude={"user","item"})
//user와 item들이 서로 상호 참조를 이루고있기 때문에 tostring시에 오버플로가 발생하게 된다.
//위의 annotation은 user와 item은 tostring()에서 제외하는내용의 annotation이다
@ToString(exclude = {"orderGroup","item"})
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    //OrderDetail N : 1 Item
    @ManyToOne
    private Item item;


    //OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;


   /* //N : 1 order와 user간의 관계
    @ManyToOne
    private User user;// 알아서 user_id를 찾아내게 된다.

    //N : 1 orderdetail과 item과의 관계
    @ManyToOne
    private Item item;*/
}
