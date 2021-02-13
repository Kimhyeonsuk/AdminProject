package com.example.adminproject.model.network.request;

import java.time.LocalDateTime;

public class AdminUserApiRequest {
    private Long id;

    private String account;

    private String password;

    private String status;

    private String role;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

}
