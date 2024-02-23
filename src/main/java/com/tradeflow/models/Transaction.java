package com.tradeflow.models;

import com.tradeflow.enums.CoinName;

import java.sql.Timestamp;
import java.util.UUID;

public class Transaction {
    private UUID transactionId;
    private Double amount;
    private CoinName coinName;
    private User sender;
    private User recipient;
    private Timestamp transactionDate;

    public Transaction(UUID transactionId, Double amount, CoinName coinName, User sender, User recipient, Timestamp transactionDate) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.coinName = coinName;
        this.sender = sender;
        this.recipient = recipient;
        this.transactionDate = transactionDate;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CoinName getCoinName() {
        return coinName;
    }

    public void setCoinName(CoinName coinName) {
        this.coinName = coinName;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", coinName=" + coinName +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
