package com.flower.service.impl;

import com.flower.entity.Address;
import com.flower.repository.AddressRepository;
import com.flower.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> list() {
        return addressRepository.findAll();
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }
}
