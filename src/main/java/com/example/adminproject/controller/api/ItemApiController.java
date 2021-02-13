package com.example.adminproject.controller.api;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.ItemApiRequest;
import com.example.adminproject.model.network.response.ItemApiResponse;
import com.example.adminproject.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j//디버깅시 로그 확인 가능
@RestController
@RequestMapping("/api/item")
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {
    @Autowired
    private ItemApiLogicService itemApiLoginService;
    @Override
    @PostMapping("") // /api/item
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLoginService.create(request);
    }

    @Override
    @GetMapping("{id}") // /api/item/1......1000~~
    public Header<ItemApiResponse> read(@PathVariable Long id) {
        return itemApiLoginService.read(id);
    }

    @Override
    @PutMapping("") // /api/item
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLoginService.update(request);
    }

    @Override
    @DeleteMapping("{id}") // /api/item
    public Header<ItemApiResponse> delete(@PathVariable Long id) {
        return itemApiLoginService.delete(id);
    }
}
