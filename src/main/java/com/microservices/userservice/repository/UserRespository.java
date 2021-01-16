package com.microservices.userservice.repository;

import com.microservices.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository
public interface UserRespository extends JpaRepository<User,Long> {

    User findByUserId(Long userId);
}
