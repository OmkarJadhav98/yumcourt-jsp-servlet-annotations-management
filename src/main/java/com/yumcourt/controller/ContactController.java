package com.yumcourt.controller;

import com.yumcourt.model.Contact;
import com.yumcourt.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<?> getAllContacts(@RequestParam(required = false) Long id) {
        if (id != null) {
            Contact contact = contactService.findContactById(id);
            if (contact != null) {
                return ResponseEntity.ok(contact);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"error\": \"Contact not found\"}");
            }
        } else {
            List<Contact> contacts = contactService.retrieveContacts();
            return ResponseEntity.ok(contacts);
        }
    }

    @PostMapping
    public ResponseEntity<String> createContact(@RequestBody Contact contact) {
        contactService.createContact(contact);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\": \"Contact created successfully\"}");
    }

    @PutMapping
    public ResponseEntity<String> updateContact(@RequestBody Contact contact) {
        contactService.updateContact(contact);
        return ResponseEntity.ok("{\"message\": \"Contact updated successfully\"}");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteContact(@RequestParam long id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok("{\"message\": \"Contact deleted successfully\"}");
    }
}
