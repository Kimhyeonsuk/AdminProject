package com.example.adminproject.repository;

import com.example.adminproject.AdminprojectApplicationTests;
import com.example.adminproject.model.entity.AdminUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends AdminprojectApplicationTests {
    @Autowired
    AdminUserRepository adminUserRepository;
    @Test
    public void create(){
        AdminUser adminUser=new AdminUser();
        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("AdminUser01");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");//SUPER, PARTNER
        /*adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("AdminServer");*/

        AdminUser newAdminUser=adminUserRepository.save(adminUser);
        Assertions.assertNotNull(newAdminUser);

        newAdminUser.setAccount("CHANGE");
        adminUserRepository.save(newAdminUser);
    }
}
