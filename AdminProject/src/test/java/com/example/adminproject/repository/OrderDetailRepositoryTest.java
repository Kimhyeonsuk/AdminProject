package com.example.adminproject.repository;

import com.example.adminproject.AdminprojectApplicationTests;
import com.example.adminproject.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminprojectApplicationTests {

    @Autowired OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        //어떠한 장바구니에
        //orderDetail.setOrderGroupId(1L);
        //어떠한 상품
        //orderDetail.setItemId(1L);
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail newOrderDetail=orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail);
    }
    @Test
    public void read(){

    }
}
