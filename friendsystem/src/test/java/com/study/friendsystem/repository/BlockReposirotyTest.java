package com.study.friendsystem.repository;

import com.study.friendsystem.domain.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockReposirotyTest {
    @Autowired
    private BlockReposiroty blockReposiroty;

    @Test
    void crud(){
        Block block=new Block();
        block.setName("martin");
        block.setReason("친하지 않아서");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockReposiroty.save(block);
        List<Block> blocks=blockReposiroty.findAll();

        Assertions.assertEquals(blocks.size(),1);
        Assertions.assertEquals(blocks.get(0).getName(),"martin");
    }
}