package com.marakicode.springstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Setter
@Getter
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "id")
    private Long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Builder.Default
    @ToString.Exclude
    @ManyToMany(
            mappedBy = "tags"
    )
    private Set<User> users = new HashSet<>();

// It is not necessary to the following because I have done on the other end of the relation
//    public void addUser(User user) {
//        users.add(user);
//    }
//
//    public void removeUser(User user) {
//        users.remove(user);
//    }
}
