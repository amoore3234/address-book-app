package com.service.address_book.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.service.address_book.model.AddressBookModel;
import com.service.address_book.service.AddressBookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class AddressBookController {

  private final AddressBookService addressBookService;

  @GetMapping(value="/addressBooks")
  public ResponseEntity<List<AddressBookModel>> getAddressBooks() {
    try {
      return ResponseEntity.ok().body(addressBookService.getAddressBooks());
    } catch(ResponseStatusException e) {
      return ResponseEntity.status(e.getStatusCode()).build();
    }
  }

  @GetMapping(value="/addressBooks/{id}")
  public ResponseEntity<AddressBookModel> getAddressBookById(Long id) {
    try {
      return ResponseEntity.ok().body(addressBookService.getAddressBookById(id));
    } catch(ResponseStatusException e) {
      return ResponseEntity.status(e.getStatusCode()).build();
    }
  }

  @PostMapping(value="/addressBook")
  public ResponseEntity<AddressBookModel> createAddressBook(AddressBookModel addressBook) {
    try {
      AddressBookModel address = new AddressBookModel();
      address.setFirstName(addressBook.getFirstName());
      address.setLastName(addressBook.getLastName());
      address.setPhoneNumber(addressBook.getPhoneNumber());
      address.setHomeAddress(addressBook.getHomeAddress());
      address.setHomeCity(addressBook.getHomeCity());
      address.setHomeState(addressBook.getHomeState());
      address.setHomeZipCode(addressBook.getHomeZipCode());

      return ResponseEntity.ok().body(addressBookService.createAddressBook(address));
    } catch (ResponseStatusException e) {
      return ResponseEntity.status(e.getStatusCode()).build();
    }
  }

  @DeleteMapping(value="/addressBook/{id}")
  public void deleteAddressBook(Long id) {
    addressBookService.deleteAddressBook(id);
    ResponseEntity.noContent();
  }

}