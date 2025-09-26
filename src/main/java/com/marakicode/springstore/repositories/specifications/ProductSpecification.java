package com.marakicode.springstore.repositories.specifications;

import com.marakicode.springstore.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProductSpecification {
    public static Specification<Product> hasName(String name) {
        return (root,query,builder)-> builder.like(root.get("name"),"%" + name +  "%");
    }

    public static Specification<Product> hasDescription(String description) {
        return (root,query, builder)->  builder.like(root.get("description"),"%" + description +  "%");
    }

    public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal minPrice) {
        return (root,query, builder)->builder.greaterThanOrEqualTo(root.get("price"),minPrice);
    }

    public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal maxPrice) {
        return (root,query, builder)->builder.lessThanOrEqualTo(root.get("price"),maxPrice);
    }
}
