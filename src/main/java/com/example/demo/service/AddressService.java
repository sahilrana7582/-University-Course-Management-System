package com.example.demo.service;

import com.example.demo.dto.address.CreateAddressDTO;
import com.example.demo.model.User;
import com.example.demo.model.address.Address;
import com.example.demo.respository.AddressRepository;
import com.example.demo.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRespository userRespository;


    public CreateAddressDTO createAddress(Long userId, CreateAddressDTO createAddressDTO) {
        User existingUser = userRespository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Address newAddress = new Address(
                null,
                createAddressDTO.getHouseNumber(),
                createAddressDTO.getFullAddress(),
                createAddressDTO.getCity(),
                createAddressDTO.getState(),
                createAddressDTO.getPostalCode(),
                createAddressDTO.getCountry(),
                existingUser
        );

        existingUser.setAddress(newAddress);

        addressRepository.save(newAddress);
        userRespository.save(existingUser);

        return new CreateAddressDTO(
                newAddress.getId(),
                newAddress.getHouseNumber(),
                newAddress.getFullAddress(),
                newAddress.getCity(),
                newAddress.getState(),
                newAddress.getPostalCode(),
                newAddress.getCountry(),
                existingUser.getId()
        );
    }


}
