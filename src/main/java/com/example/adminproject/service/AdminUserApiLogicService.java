package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.AdminUserApiRequest;
import com.example.adminproject.model.network.response.AdminUserApiResponse;
import org.springframework.stereotype.Service;

@Service
public class AdminUserApiLogicService implements CrudInterface<AdminUserApiRequest, AdminUserApiResponse> {
    @Override
    public Header<AdminUserApiResponse> create(Header<AdminUserApiRequest> request) {
        return null;
    }

    @Override
    public Header<AdminUserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<AdminUserApiResponse> update(Header<AdminUserApiRequest> request) {
        return null;
    }

    @Override
    public Header<AdminUserApiResponse> delete(Long id) {
        return null;
    }
}
