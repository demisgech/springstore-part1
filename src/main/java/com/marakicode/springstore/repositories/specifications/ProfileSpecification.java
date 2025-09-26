package com.marakicode.springstore.repositories.specifications;

import com.marakicode.springstore.entities.Profile;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class ProfileSpecification {
    public static Specification<Profile> hasBio(String bio) {
        return (root,query,builder)->builder.like(root.get("bio"),"%"+bio+"%");
    }

    public static Specification<Profile> hasLoyaltyPointsGreaterThanOrEqualTo(Integer loyaltyPoints) {
        return (root,query,builder)-> builder.greaterThanOrEqualTo(root.get("loyaltyPoints"),loyaltyPoints);
    }

    public static Specification<Profile> hasLoyaltyPointsLessThanOrEqualTo(Integer loyaltyPoints) {
        return (root,query, builder)-> builder.lessThanOrEqualTo(root.get("loyaltyPoints"),loyaltyPoints);
    }

    public static Specification<Profile> hasDateOfBirthBetween(LocalDate minDate, LocalDate maxDate) {
        return (root,query,builder)->builder.between(root.get("dateOfBirth"),minDate,maxDate);
    }
}
