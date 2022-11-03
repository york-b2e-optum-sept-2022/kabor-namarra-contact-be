package net.yorksolutions.contactsbe.controller;

import net.yorksolutions.contactsbe.DTO.NewContactRequestDTO;
import net.yorksolutions.contactsbe.entity.Contact;
import net.yorksolutions.contactsbe.services.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

    ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public Contact createContact(@RequestBody NewContactRequestDTO requestDTO){
        return this.contactService.createContact(requestDTO);
    }

    @GetMapping
    public Iterable<Contact> getContacts(@RequestParam Long accountId){
        return this.contactService.getContacts(accountId);
    }

}
