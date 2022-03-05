package com.anshul.springboot.service;

import com.anshul.springboot.entity.Merchant;

import java.util.HashMap;
import java.util.List;

public interface MerchantService {
    public Merchant saveNewMerchant(Merchant merchant);

    public List<Merchant> getMerchants();

    public Merchant updateMerchant(String merchantName, Double merchantFees);

    public HashMap<String, Double> getFees(String merchantName);
}
