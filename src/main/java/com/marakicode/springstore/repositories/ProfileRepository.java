package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Profile;
import com.marakicode.springstore.projections.UserSummary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @EntityGraph(attributePaths = "user")
    @Query("select p from Profile p where p.loyaltyPoints > :loyaltyPoints order by p.user.email")
    List<Profile> findByLoyaltyPointsGreaterThanOrderByUserEmail(@Param("loyaltyPoints") Integer loyaltyPoints);

    @EntityGraph(attributePaths = "user")
    @Query("select p.id as id, p.user.name as name,p.user.email as email from Profile p where p.loyaltyPoints > :loyaltyPoints order by p.user.email")
    List<UserSummary> findLoyalProfiles(@Param("loyaltyPoints") Integer loyaltyPoints);
}
