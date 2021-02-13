package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import org.springframework.stereotype.Service;

@Service
public class CategoryApiLogicService implements CrudInterface<CategoryApiRequest, CategoryApiResponse> {
    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
        return null;
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
        return null;
    }

    @Override
    public Header<CategoryApiResponse> delete(Long id) {
        return null;
    }
}
