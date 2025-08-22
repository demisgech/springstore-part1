package com.marakicode.springstore;

import com.marakicode.springstore.entities.Address;
import com.marakicode.springstore.entities.Category;
import com.marakicode.springstore.entities.Product;
import com.marakicode.springstore.entities.Profile;
import com.marakicode.springstore.entities.Tag;
import com.marakicode.springstore.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringstoreApplication {

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(SpringstoreApplication.class, args);

        var user = User.builder()
                .id(1L)
                .name("Maria")
                .email("maria@domain.com")
                .password("12314")
                .build();
        var address = Address.builder()
                .id(1L)
                .street("123 Main St")
                .city("Addis Ababa")
                .state("Ababa")
                .zip("12345")
                .country("Ethiopia")
                .build();

        user.addAddress(address);

        var tag = Tag.builder()
                .id(1L)
                .name("Tag1")
                .build();

        user.addTag(tag);

        System.out.println(user);

        var profile = Profile.builder()
                .id(1L)
                .bio("bio")
                .phoneNumber("123456789")
                .loyaltyPoints(1000)
                .build();
        user.addProfile(profile);
        System.out.println(user);

        var category = Category.builder()
                .name("Category1")
                .build();
        var product = Product.builder()
                .id(1L)
                .title("Product1")
                .description("Description1")
                .price(BigDecimal.valueOf(10))
                .build();

        category.addProduct(product);
        category.addProduct(product);
        System.out.println(category);
    }

}
