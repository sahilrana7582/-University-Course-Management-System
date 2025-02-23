package com.example.demo.controller;

import com.example.demo.dto.address.CreateAddressDTO;
import com.example.demo.dto.address.GetUserAddressDTO;
import com.example.demo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/{userId}")
    public ResponseEntity<CreateAddressDTO> createAddress(
            @PathVariable Long userId,
            @RequestBody CreateAddressDTO createAddressDTO) {

        CreateAddressDTO savedAddress = addressService.createAddress(userId, createAddressDTO);
        return ResponseEntity.ok(savedAddress);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<CreateAddressDTO> updateAddress(@PathVariable Long userId, @RequestBody CreateAddressDTO createAddressDTO){
        return ResponseEntity.ok(addressService.updateAddress(userId, createAddressDTO));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<GetUserAddressDTO> getUserAddress(@PathVariable Long userId){
        return ResponseEntity.ok(addressService.getUserAddress(userId));
    }

}
