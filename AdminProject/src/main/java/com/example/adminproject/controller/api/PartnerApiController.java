package com.example.adminproject.controller.api;

import com.example.adminproject.controller.CrudController;
import com.example.adminproject.model.entity.Partner;
import com.example.adminproject.model.network.request.PartnerApiRequest;
import com.example.adminproject.model.network.response.PartnerApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {
}
