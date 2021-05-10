package com.example.adminproject.service;

import com.example.adminproject.controller.CrudController;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public abstract class BaseService<Req,Res,Entity> implements CrudInterface<Req,Res> {
    @Autowired(required = false)
    protected JpaRepository<Entity,Long> baseRepository;
    //Entity값으로 jparepository를 찾아서 주입시켜준다.
}
