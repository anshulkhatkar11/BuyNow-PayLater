package com.anshul.springboot.service;

public interface PaymentService {
    public String transact(String user, String merchant, Double transactAmount);
}
