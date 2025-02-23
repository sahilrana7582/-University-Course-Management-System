package com.example.demo.respository;

import com.example.demo.model.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
