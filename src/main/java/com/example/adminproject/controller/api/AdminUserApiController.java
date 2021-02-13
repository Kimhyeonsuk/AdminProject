package com.example.adminproject.controller.api;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.AdminUserApiRequest;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.response.AdminUserApiResponse;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import com.example.adminproject.service.AdminUserApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class AdminUserApiController implements CrudInterface<AdminUserApiRequest,AdminUserApiResponse> {
    @Autowired
    AdminUserApiLogicService adminUserApiLogicService;
    @Override
    @PostMapping("")
    public Header<AdminUserApiResponse> create(@RequestBody Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<AdminUserApiResponse> read(@PathVariable Long id) {
        return adminUserApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<AdminUserApiResponse> update(@RequestBody  Header<AdminUserApiRequest> request) {
        return adminUserApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<AdminUserApiResponse> delete(@PathVariable Long id) {
        return adminUserApiLogicService.delete(id);
    }
}
