package com.service.address_book.controller;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public ResponseEntity<AddressBookModel> getAddressBookById(@PathVariable Long id) {
    try {
      return ResponseEntity.ok().body(addressBookService.getAddressBookById(id));
    } catch(ResponseStatusException e) {
      return ResponseEntity.status(e.getStatusCode()).build();
    }
  }

  @PostMapping(value="/addressBook")
  public ResponseEntity<AddressBookModel> createAddressBook(@RequestBody AddressBookModel addressBook) {
    try {
      addressBook.setCreatedTimestamp(ZonedDateTime.now());
      addressBook.setUpdatedTimestamp(ZonedDateTime.now());

      AddressBookModel createAddress = addressBookService.createAddressBook(addressBook);

      return ResponseEntity.ok().body(createAddress);
    } catch (ResponseStatusException e) {
      return ResponseEntity.status(e.getStatusCode()).build();
    }
  }

  @DeleteMapping(value="/addressBook/{id}")
  public void deleteAddressBook(@PathVariable Long id) {
    addressBookService.deleteAddressBook(id);
    ResponseEntity.noContent();
  }

}