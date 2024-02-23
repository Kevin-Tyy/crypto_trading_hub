package com.tradeflow.dto;

import com.tradeflow.models.Wallet;

import java.util.UUID;

public class UserDTO {
    private UUID userId;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private int age;
    private Wallet wallet;
}
