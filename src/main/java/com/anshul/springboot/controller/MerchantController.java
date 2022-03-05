package com.anshul.springboot.controller;

import com.anshul.springboot.entity.Merchant;
import com.anshul.springboot.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class MerchantController {
    @Autowired
    public MerchantService merchantService;

    @PostMapping("/newMerchant")
    public Merchant saveNewMerchant(@RequestBody Merchant merchant){
        return merchantService.saveNewMerchant(merchant);
    }

    @GetMapping("/merchant")
    public List<Merchant> getMerchants(){
        return merchantService.getMerchants();
    }

    @PutMapping("/merchant/{m1}/{merchantFees}")
    public Merchant updateMerchant(@PathVariable("m1") String merchantName,@PathVariable("merchantFees") Double merchantFees)
    {
        return merchantService.updateMerchant(merchantName,merchantFees);
    }

    @GetMapping("/merchant/{m1}")
    public HashMap<String,Double> getFees(@PathVariable("m1") String merchantName)
    {
        return merchantService.getFees(merchantName);
    }
}
