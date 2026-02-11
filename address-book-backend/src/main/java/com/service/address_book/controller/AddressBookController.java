package com.service.address_book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.address_book.model.AddressBookModel;
import com.service.address_book.service.AddressBookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class AddressBookController {

  private final AddressBookService addressBookService;

  @GetMapping(value="/addressBooks")
  public List<AddressBookModel> getAddressBooks() {
    return addressBookService.getAddressBooks();
  }

  @GetMapping(value="/addressBooks/{id}")
  public AddressBookModel getAddressBookById(Long id) {
    return addressBookService.getAddressBookById(id);
  }

  @PostMapping(value="/addressBook")
  public AddressBookModel createAddressBook(AddressBookModel addressBook) {
    return addressBookService.createAddressBook(addressBook);
  }

  @DeleteMapping(value="/addressBook/{id}")
  public void deleteAddressBook(Long id) {
    addressBookService.deleteAddressBook(id);
  }

}