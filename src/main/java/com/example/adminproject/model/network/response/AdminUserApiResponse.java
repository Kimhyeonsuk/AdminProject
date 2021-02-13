package com.example.adminproject.model.network.response;

import java.time.LocalDateTime;

public class AdminUserApiResponse {
    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

}
