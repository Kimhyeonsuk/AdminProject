package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Item;
import com.example.adminproject.model.entity.OrderDetail;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.ItemApiRequest;
import com.example.adminproject.model.network.request.OrderDetailApiRequest;
import com.example.adminproject.model.network.request.OrderGroupApiRequest;
import com.example.adminproject.model.network.response.ItemApiResponse;
import com.example.adminproject.model.network.response.OrderDetailApiResponse;
import com.example.adminproject.repository.ItemRepository;
import com.example.adminproject.repository.OrderDetailRepository;
import com.example.adminproject.repository.OrderGroupRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderDetailApiLogicService extends BaseService<OrderDetailApiRequest, OrderDetailApiResponse,OrderDetail> {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrderGroupRepository orderGroupRepository;
    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest body=request.getData();
        OrderDetail orderDetail=OrderDetail.builder()
                .status(body.getStatus())
                .arrivalDate(body.getArrivalDate())
                .quantity(body.getQuantity())
                .totalPrice(body.getTotalPrice())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminUser")
                .item(itemRepository.getOne(body.getItemId()))
                .orderGroup(orderGroupRepository.getOne(body.getOrderGroupId()))
                .build();

        OrderDetail newOrderDetail=baseRepository.save(orderDetail);
        return response(newOrderDetail);
    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        Optional<OrderDetail> optional= baseRepository.findById(id);
        return optional.map(orderDetail-> response(orderDetail))
                .orElseGet(()->
                        Header.ERROR("데이터가 없습니다."));
    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest body=request.getData();
        return baseRepository.findById(body.getId())
                .map(entityOrderDetail->{
                    entityOrderDetail
                            .setStatus(body.getStatus())
                            .setArrivalDate(body.getArrivalDate())
                            .setQuantity(body.getQuantity())
                            .setTotalPrice(body.getTotalPrice())
                            .setOrderGroup(orderGroupRepository.getOne(body.getOrderGroupId()))
                            .setItem(itemRepository.getOne(body.getItemId()));
                    return entityOrderDetail;
                })
                .map(newEntityOrderDetail-> baseRepository.save(newEntityOrderDetail))//저장이된 entity item 이 반환이 된다.
                .map(orderDetail->response(orderDetail))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(entityOrderDetail->{
                    baseRepository.delete(entityOrderDetail);
                    return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }


    private Header<OrderDetailApiResponse> response(OrderDetail orderDetail){
        OrderDetailApiResponse body=OrderDetailApiResponse.builder()
                .id(orderDetail.getId())
                .status(orderDetail.getStatus())
                .arrivalDate(orderDetail.getArrivalDate())
                .quantity(orderDetail.getQuantity())
                .totalPrice(orderDetail.getTotalPrice())
                .orderGroupId(orderDetail.getOrderGroup().getId())
                .itemId(orderDetail.getItem().getId())
                .build();
        return Header.OK(body);
    }
}
