package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Address;
import com.marakicode.springstore.entities.User;
import com.marakicode.springstore.projections.UserSummary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
//    String
    List<User> findByName(String name);
    List<User> findByNameLike(String name);
    List<User> findByNameNotLike(String name);

    List<User> findByNameContaining(String name);
    List<User> findByNameNotContaining(String name);

    List<User> findByNameStartsWith(String name);
    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndsWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameIgnoreCase(String name);
    List<User> findByEmailIgnoreCase(String email);

    List<UserSummary> findByAddresses(Address addresses);

    @EntityGraph(attributePaths = { "tags","addresses","wishlist" })
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = "addresses")
    @Query("select u from User u")
    List<User> findUsersWithAddresses();

    @Query("select u.id as id, u.name as name,u.email as email from User u where u.profile.loyaltyPoints > :loyaltyPoints order by u.email")
    List<UserSummary> findLoyalUsers(@Param("loyaltyPoints") Integer loyaltyPoints);
}
