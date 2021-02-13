package com.example.adminproject.controller.api;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.request.PartnerApiRequest;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import com.example.adminproject.model.network.response.PartnerApiResponse;
import com.example.adminproject.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {
    @Autowired
    PartnerApiLogicService partnerApiLogicService;
    @Override
    @PostMapping("")
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<PartnerApiResponse> read(@PathVariable Long id) {
        return partnerApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<PartnerApiResponse> update(@RequestBody  Header<PartnerApiRequest> request) {
        return partnerApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header<PartnerApiResponse> delete(@PathVariable Long id) {
        return partnerApiLogicService.delete(id);
    }
}
