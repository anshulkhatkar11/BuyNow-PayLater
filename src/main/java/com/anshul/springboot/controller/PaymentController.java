package com.anshul.springboot.controller;

import com.anshul.springboot.service.MerchantService;
import com.anshul.springboot.service.PaymentService;
import com.anshul.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    public UserService userService;

    @Autowired
    public MerchantService merchantService;

    @Autowired
    public PaymentService paymentService;

    @GetMapping("/txn/{u1}/{m1}/{value}")
    public String transaction(@PathVariable("u1") String user,@PathVariable("m1") String merchant,@PathVariable("value") Double transactAmount)
    {
        return paymentService.transact(user,merchant,transactAmount);
    }
}
