package com.marakicode.springstore.repositories;

import com.marakicode.springstore.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {
    @PersistenceContext
    private final EntityManager manager;

    @Override
    public List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
//        from products
        Root<Product> root = query.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if (name != null) {
//            name like %name%
            predicates.add(builder.like(root.get("name"), "%" + name + "%"));
        }
        if (minPrice != null) {
//            price >= minPrice
            predicates.add(builder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if (maxPrice != null) {
//            price <= maxPrice
            predicates.add(builder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        query
                .select(root)
                .where(predicates.toArray(new Predicate[predicates.size()]));

        return manager.createQuery(query).getResultList();
    }
}
