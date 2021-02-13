package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Item;
import com.example.adminproject.model.entity.OrderGroup;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.ItemApiRequest;
import com.example.adminproject.model.network.request.OrderGroupApiRequest;
import com.example.adminproject.model.network.response.ItemApiResponse;
import com.example.adminproject.model.network.response.OrderGroupApiResponse;
import com.example.adminproject.repository.OrderGroupRepository;
import com.example.adminproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderGroupApiLogicService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {
    @Autowired
    private OrderGroupRepository orderGroupRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest body=request.getData();
        OrderGroup orderGroup=OrderGroup.builder()
                .status(body.getStatus())
                .orderType(body.getOrderType())
                .revAddress(body.getRevAddress())
                .revName(body.getRevName())
                .paymentType(body.getPaymentType())
                .totalPrice(body.getTotalPrice())
                .totalQuantity(body.getTotalQuantity())
                .orderAt(LocalDateTime.now())
                .user(userRepository.getOne(body.getUserId()))
                .build();
        OrderGroup newOrderGroup=orderGroupRepository.save(orderGroup);
        return response(newOrderGroup);
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        Optional<OrderGroup> optional= orderGroupRepository.findById(id);
        return optional.map(orderGroup -> response(orderGroup))
                .orElseGet(()->
                        Header.ERROR("데이터가 없습니다."));
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        OrderGroupApiRequest body=request.getData();
        return orderGroupRepository.findById(body.getId())
                .map(entityOrderGroup ->entityOrderGroup
                            .setStatus(body.getStatus())
                            .setOrderType(body.getOrderType())
                            .setRevAddress(body.getRevAddress())
                            .setRevName(body.getRevName())
                            .setPaymentType(body.getPaymentType())
                            .setTotalPrice(body.getTotalPrice())
                            .setTotalQuantity(body.getTotalQuantity())
                            .setOrderAt(body.getOrderAt())
                            .setArrivalDate(body.getArrivalDate())
                            .setUser(userRepository.getOne(body.getUserId())))
                .map(changeOrderGroup -> orderGroupRepository.save(changeOrderGroup))
                .map(newOrderGroup -> response(newOrderGroup))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<OrderGroup> optional= orderGroupRepository.findById(id);
        return optional.map(orderGroup -> {
            orderGroupRepository.delete(orderGroup);
            return Header.OK();
        })
        .orElseGet(()->Header.ERROR("데이터가 없습니다."));
    }

    private Header<OrderGroupApiResponse> response(OrderGroup orderGroup){
        OrderGroupApiResponse body= OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .userId(orderGroup.getUser().getId())
                .build();
        return Header.OK(body);
    }
}
