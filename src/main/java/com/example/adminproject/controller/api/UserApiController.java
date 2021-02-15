package com.example.adminproject.controller.api;
import com.example.adminproject.controller.CrudController;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.User;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.UserApiRequest;
import com.example.adminproject.model.network.response.UserApiResponse;
import com.example.adminproject.model.network.response.UserOrderInfoApiResponse;
import com.example.adminproject.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j//디버깅시 로그 확인 가능
@RestController
@RequestMapping("/api/user")
public class UserApiController extends CrudController<UserApiRequest,UserApiResponse, User> {
    @Autowired
    UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }
    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort="id",direction = Sort.Direction.ASC,size=15) Pageable pageable){
        return userApiLogicService.search(pageable);
    }
}
