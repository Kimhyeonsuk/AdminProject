package com.example.adminproject.controller.api;

import com.example.adminproject.controller.CrudController;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Item;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.ItemApiRequest;
import com.example.adminproject.model.network.response.ItemApiResponse;
import com.example.adminproject.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j//디버깅시 로그 확인 가능
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {
}
