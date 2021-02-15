package com.example.adminproject.controller.api;

import com.example.adminproject.controller.CrudController;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.AdminUser;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.AdminUserApiRequest;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.response.AdminUserApiResponse;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import com.example.adminproject.service.AdminUserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j//디버깅시 로그 확인 가능
@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest,AdminUserApiResponse, AdminUser> {
}
