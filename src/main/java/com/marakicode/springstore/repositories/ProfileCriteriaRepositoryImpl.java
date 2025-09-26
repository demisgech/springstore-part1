package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Profile;
import jakarta.persistence.EntityManager;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class ProfileCriteriaRepositoryImpl implements ProfileCriteriaRepository {
    private final EntityManager manager;

    @Override
    public List<Profile> findProfilesByCriteria(String bio, LocalDate dateOfBirth, Integer loyaltyPoints) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Profile> query = builder.createQuery(Profile.class);
        Root<Profile> root = query.from(Profile.class);
        List<Predicate> predicates = new ArrayList<>();
        if (bio != null) {
            predicates.add(builder.like(root.get("bio"), "%"+bio+"%"));
        } else if (dateOfBirth != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("birthDate"), dateOfBirth));
        } else if (loyaltyPoints != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("loyaltyPoints"), loyaltyPoints));
        }
        query.select(root)
             .where(predicates.toArray(new Predicate[predicates.size()]))
             .orderBy(builder.asc(root.get("bio")));
        return manager.createQuery(query).getResultList();
    }
}
