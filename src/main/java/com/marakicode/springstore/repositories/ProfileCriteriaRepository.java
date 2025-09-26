package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Profile;

import java.time.LocalDate;
import java.util.List;

public interface ProfileCriteriaRepository {
    List<Profile> findProfilesByCriteria(String bio, LocalDate dateOfBirth, Integer loyaltyPoints);
}
