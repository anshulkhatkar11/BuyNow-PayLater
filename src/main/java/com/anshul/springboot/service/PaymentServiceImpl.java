package com.anshul.springboot.service;

import com.anshul.springboot.entity.Merchant;
import com.anshul.springboot.entity.User;
import com.anshul.springboot.repository.MerchantRepo;
import com.anshul.springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    public UserRepo userRepo;

    @Autowired
    public MerchantRepo merchantRepo;

    @Override
    public String transact(String userName, String merchantName, Double transactAmount) {
        User user=userRepo.findByUserNameIgnoreCase(userName);
        Double dues=user.getDues();
        if(dues+transactAmount> user.getCreditLimit()){
            return "rejected! (reason: credit limit)";
        }
        user.setDues(dues+transactAmount);
        Merchant merchant=merchantRepo.findByMerchantNameIgnoreCase(merchantName);
        merchant.setAmountTotal(merchant.getAmountTotal() + ((100-merchant.getMerchantFees())*transactAmount)/100);
        merchant.setFeesPaid(( merchant.getFeesPaid()+ (merchant.getMerchantFees()*transactAmount)/100));
        merchantRepo.save(merchant);
        userRepo.save(user);
        return "success";
    }
}
