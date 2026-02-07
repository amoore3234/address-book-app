package com.service.address_book.model;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
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

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "phonenumber")
  private String phoneNumber;

  @Column(name = "homeaddress")
  private String homeAddress;

  @Column(name = "homecity")
  private String homeCity;

  @Column(name = "homestate")
  private String homeState;

  @Column(name = "homezipcode")
  private String homeZipCode;

  @Column(name = "createdtimestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private ZonedDateTime createdTimestamp;

  @Column(name = "updatedtimestamp")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private ZonedDateTime updatedTimestamp;

}
