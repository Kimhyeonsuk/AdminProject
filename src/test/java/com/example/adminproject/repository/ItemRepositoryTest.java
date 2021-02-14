package com.example.adminproject.repository;

import com.example.adminproject.AdminprojectApplicationTests;
import com.example.adminproject.model.entity.Item;
import com.example.adminproject.model.enumclass.ItemStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

public class ItemRepositoryTest extends AdminprojectApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item=new Item();
        item.setStatus(ItemStatus.UNREGISTERED);
        item.setName("삼성 컴퓨터");
        item.setTitle("삼성 노트북 A100");
        item.setContent("2019년형 노트북 입니다");
        //item.setPrice(900000);
        item.setBrandName("삼성");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("Partner01");
        //item.setPartnerId(1L);
        Item newItem=itemRepository.save(item);
        Assert.notNull(newItem);
    }
    @Test
    public void read(){
        Long id=1L;
        Optional<Item> item=itemRepository.findById(id);
        Assert.isTrue(item.isPresent());
        item.ifPresent(i->{
            System.out.println(i);
        });
    }
}
