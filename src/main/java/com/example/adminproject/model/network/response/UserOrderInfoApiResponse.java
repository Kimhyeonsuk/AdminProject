package com.example.adminproject.model.network.response;

import com.example.adminproject.model.entity.OrderGroup;
import com.example.adminproject.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//사용자의 주문정보를 찾는 APIresponse
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOrderInfoApiResponse {
    private UserApiResponse userApiResponse;
}
