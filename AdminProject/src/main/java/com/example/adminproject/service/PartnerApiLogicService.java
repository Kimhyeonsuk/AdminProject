package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Partner;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.PartnerApiRequest;
import com.example.adminproject.model.network.response.PartnerApiResponse;
import com.example.adminproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PartnerApiLogicService extends BaseService<PartnerApiRequest, PartnerApiResponse, Partner> {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Header<PartnerApiResponse> create(Header<PartnerApiRequest> request) {
        PartnerApiRequest body=request.getData();

        Partner partner=Partner.builder()
                .name(body.getName())
                .status(body.getStatus())
                .address(body.getAddress())
                .callCenter(body.getCallCenter())
                .partnerNumber(body.getPartnerNumber())
                .businessNumber(body.getBusinessNumber())
                .ceoName(body.getCeoName())
                .registeredAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminUser")
                .category(categoryRepository.getOne(body.getCategoryId()))
                .build();
        Partner newPartner=baseRepository.save(partner);
        return response(newPartner);
    }

    @Override
    public Header<PartnerApiResponse> read(Long id) {
        return baseRepository.findById(id)
                .map(partner -> response(partner))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<PartnerApiResponse> update(Header<PartnerApiRequest> request) {
        PartnerApiRequest body=request.getData();
        Optional<Partner> optional=baseRepository.findById(body.getId());
        return optional.map(partner->{
            partner.setName(body.getName())
                    .setStatus(body.getStatus())
                    .setAddress(body.getAddress())
                    .setCallCenter(body.getCallCenter())
                    .setPartnerNumber(body.getPartnerNumber())
                    .setBusinessNumber(body.getBusinessNumber())
                    .setCeoName(body.getCeoName())
                    .setRegisteredAt(body.getRegisteredAt())
                    .setUnregisteredAt(body.getUnregisteredAt())
                    .setUpdatedAt(LocalDateTime.now())
                    .setUpdatedBy("AdminUser");
            return partner;
        })
                .map(partner -> baseRepository.save(partner))
                .map(partner->response(partner))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Partner> optional=baseRepository.findById(id);
        return optional.map(partner -> {
            baseRepository.delete(partner);
            return Header.OK();
        }).orElseGet(()->Header.ERROR("데이터 없음"));
    }

    private Header<PartnerApiResponse> response(Partner partner){
        PartnerApiResponse body=PartnerApiResponse.builder()
                .id(partner.getId())
                .name(partner.getName())
                .status(partner.getStatus())
                .address(partner.getAddress())
                .callCenter(partner.getCallCenter())
                .partnerNumber(partner.getPartnerNumber())
                .businessNumber(partner.getBusinessNumber())
                .ceoName(partner.getCeoName())
                .registeredAt(partner.getRegisteredAt())
                .unregisteredAt(partner.getUnregisteredAt())
                .categoryId(partner.getCategory().getId())
                .build();
        return Header.OK(body);
    }
}
