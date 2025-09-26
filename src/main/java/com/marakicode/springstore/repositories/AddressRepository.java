package com.marakicode.springstore.repositories;

import com.marakicode.springstore.dtos.AddressSummaryDto;
import com.marakicode.springstore.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.marakicode.springstore.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>, AddressCriteriaRepository {
    List<Address> findByUserId(Long id);

    List<AddressSummaryDto> findByStateAndCountry(String state, String country);

    @EntityGraph(attributePaths = {
            "user"
//            , "user.wishlist" // Just for learning
    })
    List<Address> findByUser(User user);
}