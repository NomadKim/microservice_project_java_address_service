package com.example.address.service;

import com.example.address.entity.Address;
import com.example.address.repository.AddressRepository;
import com.example.address.request.CreateAddressRequest;
import com.example.address.responce.CreateAddressResponce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    public CreateAddressResponce getById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow();

        logger.info("Inside server" + id);
        return new CreateAddressResponce(address);

    }

    public CreateAddressResponce createAddress(CreateAddressRequest createAddressRequest) {

        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());

        addressRepository.saveAndFlush(address);


        return new CreateAddressResponce(address);
    }
}
