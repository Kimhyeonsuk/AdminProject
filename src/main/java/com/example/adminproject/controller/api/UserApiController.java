package com.example.adminproject.controller.api;
import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.UserApiRequest;
import com.example.adminproject.model.network.response.UserApiResponse;
import com.example.adminproject.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j//디버깅시 로그 확인 가능
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest,UserApiResponse> {
    @Autowired
    UserApiLogicService userApiLogicService;

    @Override
    @PostMapping("") //api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{}",request);//sytemout과 유사하지만  나중에 log서비스를 추가하겠다 하면 해당 내용을 loging 해준다
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")// /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        log.info("read id : {} ",id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")// /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")// /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return userApiLogicService.delete(id);
    }
}
