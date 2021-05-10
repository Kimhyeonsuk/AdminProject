package com.example.adminproject.service;

import com.example.adminproject.ifs.CrudInterface;
import com.example.adminproject.model.entity.Category;
import com.example.adminproject.model.entity.OrderDetail;
import com.example.adminproject.model.network.Header;
import com.example.adminproject.model.network.request.CategoryApiRequest;
import com.example.adminproject.model.network.response.CategoryApiResponse;
import com.example.adminproject.model.network.response.OrderDetailApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse,Category> {
    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {
        CategoryApiRequest body=request.getData();

        Category category=Category.builder()
                .type(body.getType())
                .title(body.getTitle())
                .createdAt(LocalDateTime.now())
                .createdBy("AdminUser")
                .build();
        Category newCategory=baseRepository.save(category);
        return response(newCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        Optional<Category> optional=baseRepository.findById(id);
        return optional.map(category -> response(category))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
       CategoryApiRequest body=request.getData();

       return baseRepository.findById(body.getId())
               .map(category -> {
                   category.setType(body.getType())
                           .setTitle(body.getTitle())
                           .setUpdatedAt(LocalDateTime.now())
                           .setUpdatedBy("AdminUser");
                   return category;
               })
               .map(category -> baseRepository.save(category))
               .map(category -> response(category))
               .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return null;
    }


    private Header<CategoryApiResponse> response(Category category){
        CategoryApiResponse body=CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();
        return Header.OK(body);
    }
}
