package com.example.demo.dto.address;
import com.example.demo.model.address.Address;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserAddressDTO {
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



    public GetUserAddressDTO(Address address) {
        this.id = address.getId();
        this.houseNumber = address.getHouseNumber();
        this.fullAddress = address.getFullAddress();
        this.city = address.getCity();
        this.state = address.getState();
        this.postalCode = address.getPostalCode();
        this.country = address.getCountry();
        this.userId = address.getUser().getId(); // Ensure user is not null
    }
}
