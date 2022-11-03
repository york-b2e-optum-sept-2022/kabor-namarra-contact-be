package net.yorksolutions.contactsbe.repository;

import net.yorksolutions.contactsbe.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {

    Optional<Account> findByUsernameAndPassword(String username, String password);
}
