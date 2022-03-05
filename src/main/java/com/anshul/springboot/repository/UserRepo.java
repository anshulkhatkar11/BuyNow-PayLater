package com.anshul.springboot.repository;

import com.anshul.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    public User findByUserNameIgnoreCase(String userName);
}
