package com.example.adminproject.controller.api;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.request.OrderDetailApiRequest;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import com.example.adminproject.model.network.response.OrderDetailApiResponse;
import com.example.adminproject.service.CategoryApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class CategoryApiController implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {
    @Autowired
    CategoryApiLogicService categoryApiLogicService;
    @Override
    @PostMapping("")
    public Header<CategoryApiResponse> create(@RequestBody Header<CategoryApiRequest> request) {
        return categoryApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<CategoryApiResponse> read(@PathVariable Long id) {
        return categoryApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<CategoryApiResponse> update(@RequestBody  Header<CategoryApiRequest> request) {
        return categoryApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<CategoryApiResponse> delete(@PathVariable Long id) {
        return categoryApiLogicService.delete(id);
    }
}
