package net.yorksolutions.contactsbe.repository;

import net.yorksolutions.contactsbe.entity.Account;
import net.yorksolutions.contactsbe.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    Iterable<Contact> findAllByOwner(Account owner);
}
