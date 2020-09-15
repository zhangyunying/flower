package com.flower.service;

import com.flower.entity.Address;
import com.flower.entity.Service;

import java.util.List;

public interface AddressService {
    List<Address> list();

    void addAddress(Address address);
}
