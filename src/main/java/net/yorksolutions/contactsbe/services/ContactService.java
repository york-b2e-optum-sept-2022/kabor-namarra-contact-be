package net.yorksolutions.contactsbe.services;

import net.yorksolutions.contactsbe.DTO.NewContactRequestDTO;
import net.yorksolutions.contactsbe.entity.Account;
import net.yorksolutions.contactsbe.entity.Contact;
import net.yorksolutions.contactsbe.repository.AccountRepository;
import net.yorksolutions.contactsbe.repository.ContactRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ContactService {

    ContactRepository contactRepository;
    AccountRepository accountRepository;

    public ContactService(ContactRepository contactRepository, AccountRepository accountRepository) {
        this.contactRepository = contactRepository;
        this.accountRepository = accountRepository;
    }


    public Contact createContact(NewContactRequestDTO requestDTO){
        Optional<Account> accountOpt = this.accountRepository.findById(requestDTO.ownerId);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return this.contactRepository.save(
                new Contact(accountOpt.get(),requestDTO.firstname, requestDTO.lastname,requestDTO.phoneNumber, requestDTO.favorite));
    }

    public Iterable<Contact> getContacts(Long accountId){
        Optional<Account> accountOpt = this.accountRepository.findById(accountId);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return this.contactRepository.findAllByOwner(accountOpt.get());
    }

    public void deleteContact(Long contactId){
        this.contactRepository.deleteById(contactId);
    }


}
