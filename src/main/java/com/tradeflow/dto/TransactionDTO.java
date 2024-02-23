package com.tradeflow.dto;

import com.tradeflow.models.User;

import java.sql.Timestamp;
import java.util.UUID;

public class TransactionDTO {
    private UUID transactionId;
    private Double amount;
    private User sender;
    private User recipient;
    private Timestamp transactionDate;
}
