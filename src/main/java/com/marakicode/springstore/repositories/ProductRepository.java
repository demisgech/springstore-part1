package com.marakicode.springstore.repositories;

import com.marakicode.springstore.dtos.ProductSummaryDto;
import com.marakicode.springstore.entities.Category;
import com.marakicode.springstore.entities.Product;
import com.marakicode.springstore.projections.ProductSummary;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    //    Numbers
    List<Product> findByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceGreaterThanEqual(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByPriceLessThanEqual(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    //    Nullable
    List<Product> findByDescriptionNull();

    List<Product> findByDescriptionNotNull();

    //    Multiple conditions
    List<Product> findByDescriptionNullAndNameNotNull();

    List<Product> findByDescriptionNotNullAndNameNotNull();

    List<Product> findByDescriptionNullAndNameNull();

    List<Product> findByPriceGreaterThanOrName(BigDecimal price, String name);

    List<Product> findByPriceGreaterThanOrNameIgnoreCase(BigDecimal price, String name);

    List<Product> findByPriceGreaterThanOrNameNull(BigDecimal price);

    List<Product> findByPriceGreaterThanOrNameNotNull(BigDecimal price);

    //    Sorting
    List<Product> findByPriceOrderByName(BigDecimal price);

    List<Product> findByPriceOrderByNameDesc(BigDecimal price);

    //    List<Product> findByPriceBetweenOrderByName(BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findByPriceAndNameOrderByName(BigDecimal price, String name);

    List<Product> findByPriceAndNameOrderByNameDesc(BigDecimal price, String name);

    List<Product> findByPriceBetweenAndNameOrderByPriceDesc(BigDecimal minPrice, BigDecimal maxPrice, String name);

    //    Limit(Top/First)
    List<Product> findTop5ByNameOrderByName(String name);

    List<Product> findFirst5ByNameOrderByPriceDesc(String name);

//    Custom Queries
//    Find products whose prices are in a given range and sort by name

//    List<Product> findByPriceBetweenOrderByName(BigDecimal minPrice, BigDecimal maxPrice);

    //    SQL or
//    @Query(value = "SELECT * FROM products p WHERE p.price BETWEEN :min AND :max ORDER BY p.name", nativeQuery = true)
//    List<Product> findProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max);
//    JPQL(Java Persistence Query Language)
//    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :min AND :max ORDER BY p.name")
//    List<Product> findProducts(@Param("min") BigDecimal min,@Param("max") BigDecimal max);
//
//@Query("select p from Product p where p.price between :minPrice and :maxPrice order by p.name")
//List<Product> findProducts(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);
    @Query("select p from Product p left join p.category where p.price between :minPrice and :maxPrice order by p.name")
    List<Product> findProducts(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

//    Aggregate functions

    @Query("select count(p) from Product p where p.price > ?1")
    long countByPriceGreaterThan(BigDecimal price);

    @Query("select sum(p.price) from Product p")
    BigDecimal getTotalPrice();

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);
// Projections
//    List<ProductSummary> findByCategory(Category category);
    List<ProductSummaryDto> findByCategory(Category category);


    @Query("select p.id,p.name from Product p where p.category.id = :categoryId or upper(p.name) = upper(:name)")
    List<ProductSummary> findByCategoryIdOrNameIgnoreCase(@Param("categoryId") Byte categoryId, @Param("name") String name);

    @Query("select new com.marakicode.springstore.dtos.ProductSummaryDto(p.id,p.name,p.price) from Product p where p.category = :category or p.name = :name")
    List<ProductSummaryDto> findByCategoryOrName(@Param("category") Category category, @Param("name") String name);

    @Procedure("findProductByPrice")
    List<Product> findProductByPrice(BigDecimal minPrice, BigDecimal maxPrice);
}