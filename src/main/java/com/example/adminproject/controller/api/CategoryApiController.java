package com.example.adminproject.controller.api;

import com.example.adminproject.controller.CrudController;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Category;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.request.OrderDetailApiRequest;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import com.example.adminproject.model.network.response.OrderDetailApiResponse;
import com.example.adminproject.service.CategoryApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j//디버깅시 로그 확인 가능
@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse, Category> {
}
