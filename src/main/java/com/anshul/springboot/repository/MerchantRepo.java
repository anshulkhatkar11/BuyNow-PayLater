package com.anshul.springboot.repository;

import com.anshul.springboot.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepo extends JpaRepository<Merchant,String> {
    public Merchant findByMerchantNameIgnoreCase(String merchantName);
}
