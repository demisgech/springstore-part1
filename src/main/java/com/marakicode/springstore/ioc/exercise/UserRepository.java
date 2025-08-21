package com.marakicode.springstore.ioc.exercise;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}
