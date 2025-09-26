package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class AddressCriteriaRepositoryImpl implements AddressCriteriaRepository {
    private final EntityManager manager;

    @Override
    public List<Address> findAddressesByCriteria(String street, String city, String state, String zipcode, String country) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Address> query = builder.createQuery(Address.class);
        Root<Address> root = query.from(Address.class);
        List<Predicate> predicates = new ArrayList<>();

        if (street != null) {
            predicates.add(builder.like(root.get("street"), "%" + street + "%"));
        }
        if (city != null) {
            predicates.add(builder.like(root.get("city"), "%" + city + "%"));
        }
        if (state != null) {
            predicates.add(builder.like(root.get("state"), "%" + state + "%"));
        }
        if (zipcode != null) {
            predicates.add(builder.like(root.get("zipcode"), "%" + zipcode + "%"));
        }
        if (country != null) {
            predicates.add(builder.like(root.get("country"), "%" + country + "%"));
        }
        query.select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]))
                .orderBy(builder.asc(root.get("country")));
        return manager.createQuery(query).getResultList();
    }
}
