package com.service.address_book.model;

import java.time.ZonedDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_data")
public class AddressBookModel {

  @Id
  @Nonnull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String homeAddress;
  private String homeCity;
  private String homeState;
  private String homeZipCode;
  private ZonedDateTime createdTimestamp;
  private ZonedDateTime updatedTimestamp;
  
}
