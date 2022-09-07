package com.example.address.responce;

import com.example.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressResponce {
    private Long addressId;
    private String street;
    private String city;

     public CreateAddressResponce(Address address){
         this.addressId = address.getId();
         this.street = address.getStreet();
         this.city = address.getCity();
     }
}
