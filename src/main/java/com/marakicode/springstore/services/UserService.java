package com.marakicode.springstore.services;


import com.marakicode.springstore.entities.Address;
import com.marakicode.springstore.entities.Category;
import com.marakicode.springstore.entities.User;
import com.marakicode.springstore.repositories.AddressRepository;
import com.marakicode.springstore.repositories.CategoryRepository;
import com.marakicode.springstore.repositories.ProductRepository;
import com.marakicode.springstore.repositories.ProfileRepository;
import com.marakicode.springstore.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
//import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service("user-service")
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("daniel")
                .email("daniel@domain.com")
                .password("password")
                .build();
        if (entityManager.contains(user))
            System.out.println("User is in persistence state");
        else
            System.out.println("User is in a transient or detached state");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("User is in persistence state");
        else
            System.out.println("User is in a transient or detached state");
    }

    @Transactional
    public void showRelatedEntities() {
        var user = userRepository.findById(2L).orElseThrow();
        System.out.println(user.getName());
    }

    public void fetchProfiles() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getBio());
        System.out.println(profile.getUser().getEmail());
    }

    @Transactional
    public void fetchAddress() {
//        var address = addressRepository.findById(5L).orElseThrow();
//        System.out.println(address.getCity());
//        System.out.println(address.getUser().getName());
//
//        var addressByUser = addressRepository.findByUserId(4L);
//        System.out.println(addressByUser.getFirst().getState());
//        var addresses = addressRepository.findByStateAndCountry("state","country");
//        addresses.forEach(System.out::println);
        var addresses = addressRepository.findByUser(new User(1L));
        addresses.forEach(address -> {
            System.out.println(address.getCity());
        });
    }

    public void persistRelated() {
        var user = User.builder()
                .name("a.123")
                .email("a.123@domain.com")
                .password("password")
                .build();
        var address = Address.builder()
                .state("state")
                .city("city")
                .country("country")
                .zip("zip")
                .street("street")
                .build();
        user.addAddress(address);
        userRepository.save(user);
//        addressRepository.save(address);
    }

    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(17L);
        var user = userRepository.findById(15L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
//        var category = Category.builder()
//                .name("Category 2")
//                .build();
//        var category = categoryRepository.findById(1L).orElseThrow();
//        var product = Product.builder()
//                .name("Product 2")
//                .price(BigDecimal.valueOf(10.11))
//                .description("Description 1")
//                .build();
//        category.addProduct(product);
//        productRepository.save(product);
//        var antherProduct =Product.builder()
//                .name("Product 3")
//                .price(BigDecimal.valueOf(3.99))
//                .description("Description 3")
//                .build();
//        var anotherCategory = categoryRepository.findById(2L).orElseThrow();
//        anotherCategory.addProduct(antherProduct);
//        productRepository.save(antherProduct);
//        var user = userRepository.findById(6L).orElseThrow();
//        var products = productRepository.findAll();
//        products.forEach(user::addWishlist);
//        userRepository.save(user);

//        productRepository.deleteById(2L);

//        var product = productRepository.findByPriceGreaterThanOrNameNotNull(BigDecimal.valueOf(10));
//        var product = productRepository.findByPriceGreaterThanOrNameIgnoreCase(BigDecimal.valueOf(10),"Product 1");
        var product = productRepository.findByPriceBetweenAndNameOrderByPriceDesc(BigDecimal.valueOf(10), BigDecimal.valueOf(20), "Product 1");
        System.out.println(product.getFirst().getName());
    }

    @Transactional
    public void manageUsers() {
//        var user = userRepository.findByEmail("ab@domain.com").orElseThrow();
//        System.out.println(user.getId());
//        System.out.println(user);

//        var profile = Profile.builder()
//                .loyaltyPoints(20)
//                .phoneNumber("22345678")
//                .bio("my bio")
//                .build();
//        var user = User.builder()
//                .email("user3@domain.com")
//                .name("user3")
//                .password("password")
//                .build();
//        profile.setUser(user);
//        profileRepository.save(profile);

        var usersProfiles = profileRepository.findLoyalProfiles(10);
        usersProfiles.forEach(userSummary ->
                System.out.println(
                                "{ id: " + userSummary.getId() +
                                ", name: " + userSummary.getName() +
                                ", email: " + userSummary.getEmail() + " }"));
    }

    @Transactional
    public void updatePrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 1);
    }

    public void fetchProducts() {
//        var products = productRepository.findByCategory(new Category((byte) 1));
//        products.forEach(System.out::println);

//        var products = productRepository.findByCategoryIdOrNameIgnoreCase((byte)1,"Product 1");
//        System.out.println(products);

        var products = productRepository.findByCategoryOrName(new Category((byte)1),"product 1");
        products.forEach(System.out::println);

    }

    @Transactional
    public void fetchUsers() {
//        userRepository
//                .findByAddresses(new Address(5L))
//                .forEach(System.out::println);
        var users = userRepository.findUsersWithAddresses();
        users.forEach(user->{
            System.out.println(user);
            System.out.println(user.getAddresses());
        });
    }

    @Transactional
    public void callStoreProcedure(){
        var products = productRepository.findProductByPrice(BigDecimal.valueOf(10), BigDecimal.valueOf(20));
        products.forEach(System.out::println);
    }
}
