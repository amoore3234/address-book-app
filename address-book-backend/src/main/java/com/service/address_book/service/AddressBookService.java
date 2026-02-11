package com.service.address_book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.address_book.model.AddressBookModel;
import com.service.address_book.repository.AddressBookRespository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressBookService {

  private final AddressBookRespository addressBookRepository;

  public List<AddressBookModel> getAddressBooks() {
    return addressBookRepository.findAll();
  }

  public AddressBookModel getAddressBookById(Long id) {
    return addressBookRepository.findById(id).orElse(null);
  }

  public AddressBookModel createAddressBook(AddressBookModel addressBook) {
    return addressBookRepository.save(addressBook);
  }

  public AddressBookModel updateAddressBook(Long id, AddressBookModel addressBook) {
    AddressBookModel existingAddressBook = addressBookRepository.findById(id).orElse(null);
    if (existingAddressBook != null) {
      existingAddressBook.setFirstName(addressBook.getFirstName());
      existingAddressBook.setLastName(addressBook.getLastName());
      existingAddressBook.setHomeAddress(addressBook.getHomeAddress());
      existingAddressBook.setHomeCity(addressBook.getHomeCity());
      existingAddressBook.setHomeState(addressBook.getHomeState());
      existingAddressBook.setHomeZipCode(addressBook.getHomeZipCode());
      existingAddressBook.setPhoneNumber(addressBook.getPhoneNumber());
      return addressBookRepository.save(existingAddressBook);
    }
    return null;
  }

  public void deleteAddressBook(Long id) {
    addressBookRepository.deleteById(id);
  }

}
