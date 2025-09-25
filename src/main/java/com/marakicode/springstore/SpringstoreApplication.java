package com.marakicode.springstore;

import com.marakicode.springstore.entities.Category;
import com.marakicode.springstore.entities.User;
import com.marakicode.springstore.repositories.CategoryRepository;
import com.marakicode.springstore.repositories.UserRepository;
import com.marakicode.springstore.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringstoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringstoreApplication.class, args);
        var repository = context.getBean(UserRepository.class);
//        var user = User.builder()
//                .name("Haile")
//                .email("Haile@domain.com")
//                .password("1234")
//                .build();
//        repository.save(user);

//        repository.findAll()
//                .forEach(user-> System.out.println(user.getName()));
//
//        var user = repository.findById(1L).orElseThrow(()->new RuntimeException("User not found"));
//        System.out.println(user.getEmail());

//        repository.deleteById(5L);

        UserService userService = context.getBean(UserService.class);
//        userService.showEntityStates();

//        userService.showRelatedEntities();
//        userService.fetchAddress();
//        userService.persistRelated();
//        userService.deleteRelated();
//        userService.manageProducts();
//        userService.updatePrices();
//        userService.fetchProducts();
//        userService.callStoreProcedure();
//        userService.fetchUsers();
        userService.manageUsers();
//        var categoryRepository = context.getBean(CategoryRepository.class);
//        var category = Category.builder()
//                .name("Category 1")
//                .build();
//        categoryRepository.save(category);
    }
}
