package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Item;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.ItemApiRequest;
import com.example.adminproject.model.network.response.ItemApiResponse;
import com.example.adminproject.repository.ItemRepository;
import com.example.adminproject.repository.PartnerRepository;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ItemApiLogicService extends BaseService<ItemApiRequest,ItemApiResponse,Item> {
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        ItemApiRequest body=request.getData();
        Item item=Item.builder()
                .status(body.getStatus())
                .name(body.getName())
                .title(body.getTitle())
                .content(body.getContent())
                .price(body.getPrice())
                .brandName(body.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnerRepository.getOne(body.getPartnerId()))
                .build();
        Item newItem= baseRepository.save(item);
        return response(newItem);

    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        Optional<Item> optional= baseRepository.findById(id);
        return optional.map(item -> response(item))
                .orElseGet(()->
                    Header.ERROR("데이터가 없습니다."));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        ItemApiRequest body=request.getData();
        return baseRepository.findById(body.getId())
                .map(entityItem->{
                    entityItem
                            .setStatus(body.getStatus())
                            .setName(body.getName())
                            .setTitle(body.getTitle())
                            .setContent(body.getContent())
                            .setPrice(body.getPrice())
                            .setBrandName(body.getBrandName())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt());

                    return entityItem;
                })
                .map(newEntityItem-> baseRepository.save(newEntityItem))//저장이된 entity item 이 반환이 된다.
                .map(item->response(item))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Item> optional= baseRepository.findById(id);
        //map은 return 해야한다.
        return optional.map(item -> {
            baseRepository.delete(item);
            return Header.OK();
        })
        .orElseGet(()->Header.ERROR("데이터가 없습니다."));
    }

    public Header<ItemApiResponse> response(Item item){
        ItemApiResponse body=ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();
        return Header.OK(body);
    }
}
