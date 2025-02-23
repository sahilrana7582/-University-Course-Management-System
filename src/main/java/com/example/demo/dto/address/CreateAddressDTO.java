package com.example.demo.dto.address;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressDTO {

    private Long id;

    @Min(1)
    private int houseNumber;

    @NotBlank
    private String fullAddress;

    @NotBlank
    private String city;

    @NotBlank
    private String state;


    private Long postalCode;

    @NotBlank
    private String country;

    private Long userId;
}


