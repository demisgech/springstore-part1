package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Address;

import java.util.List;

public interface AddressCriteriaRepository {
    List<Address> findAddressesByCriteria(String street, String city, String state, String zipcode, String country);
}
