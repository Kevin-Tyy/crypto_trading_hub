package com.tradeflow.models;

import java.util.List;
import java.util.UUID;

public class Wallet {
    private UUID walletAddress;
    private User user;
    private double balance;
    private List<Transaction> transactions;

    public Wallet(UUID walletAddress, User user, double balance, List<Transaction> transactions) {
        this.walletAddress = walletAddress;
        this.user = user;
        this.balance = balance;
        this.transactions = transactions;
    }

    public UUID getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(UUID walletAddress) {
        this.walletAddress = walletAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletAddress=" + walletAddress +
                ", user=" + user +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
