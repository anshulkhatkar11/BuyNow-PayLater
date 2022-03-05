package com.anshul.springboot.service;

import com.anshul.springboot.entity.Merchant;
import com.anshul.springboot.repository.MerchantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    public MerchantRepo merchantRepo;

    @Override
    public Merchant saveNewMerchant(Merchant merchant) {
        return merchantRepo.save(merchant);
    }

    @Override
    public List<Merchant> getMerchants() {
        return merchantRepo.findAll();
    }

    @Override
    public Merchant updateMerchant(String merchantName, Double merchantFees) {
        Merchant merchant=merchantRepo.findByMerchantNameIgnoreCase(merchantName);
        merchant.setMerchantFees(merchantFees);
        merchantRepo.save(merchant);
        return merchant;
    }

    @Override
    public HashMap<String, Double> getFees(String merchantName) {
        Merchant merchant=merchantRepo.findByMerchantNameIgnoreCase(merchantName);
        HashMap<String,Double> hm=new HashMap<>();
        hm.put(merchantName, merchant.getFeesPaid());

        return hm;
    }
}
