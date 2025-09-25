package com.marakicode.springstore.repositories;
import com.marakicode.springstore.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
