package com.example.adminproject.controller.api;

import com.example.adminproject.controller.CrudController;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.OrderDetail;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.OrderDetailApiRequest;
import com.example.adminproject.model.network.response.OrderDetailApiResponse;
import com.example.adminproject.service.OrderDetailApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orderDetail")
public class OrderDetailApiController extends CrudController<OrderDetailApiRequest, OrderDetailApiResponse, OrderDetail> {
}
