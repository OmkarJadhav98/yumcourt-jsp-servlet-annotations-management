package com.yumcourt.service;

import com.yumcourt.model.Contact;
import com.yumcourt.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> retrieveContacts() {
        return contactRepository.findAll(); // Use JpaRepository's findAll method
    }

    public void createContact(Contact contact) {
        contactRepository.save(contact); // Use JpaRepository's save method
        System.out.println("Contact created successfully.");
    }

    public void updateContact(Contact contact) {
        contactRepository.save(contact); // Use JpaRepository's save method for both create and update
        System.out.println("Contact updated successfully.");
    }

    public void deleteContact(long id) {
        contactRepository.deleteById(id); // Use JpaRepository's deleteById method
        System.out.println("Contact deleted successfully.");
    }

    public Contact findContactById(long id) {
        return contactRepository.findById(id).orElse(null); // Handle Optional returned by findById
    }
}
