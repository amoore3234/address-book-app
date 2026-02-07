package com.service.address_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.address_book.model.AddressBookModel;

public interface AddressBookRespository extends JpaRepository<AddressBookModel, Long>{

}
