package com.marakicode.springstore.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@Table(name = "addresses")
public class Address {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id",nullable = false)
   private Long id;

   @Column(name = "street",nullable = false)
   private String street;

   @Column(name = "city",nullable = false)
   private String city;

   @Column(name = "state", nullable = false)
   private String state;

   @Column(name = "zip",nullable = false)
   private String zip;

   @Column(name = "country")
   private String country;

   @ToString.Exclude
   @ManyToOne(
           fetch = FetchType.LAZY
   )
   @JoinColumn(
           name = "user_id"
   )
   private User user;

   public Address(Long id) {
       this.id = id;
   }

}
