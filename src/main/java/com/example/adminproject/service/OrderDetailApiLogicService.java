package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.OrderDetailApiRequest;
import com.example.adminproject.model.network.response.OrderDetailApiResponse;
import com.example.adminproject.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailApiLogicService implements CrudInterface<OrderDetailApiRequest, OrderDetailApiResponse> {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> delete(Long id) {
        return null;
    }
}
