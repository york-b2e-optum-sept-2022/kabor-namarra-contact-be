package net.yorksolutions.contactsbe.services;

import net.yorksolutions.contactsbe.DTO.NewAccountRequestDTO;
import net.yorksolutions.contactsbe.entity.Account;
import net.yorksolutions.contactsbe.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account createAccount(NewAccountRequestDTO requestDTO){
        try {
            return this.accountRepository.save(new Account(requestDTO.username, requestDTO.password));
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    public Account loginAccount(String username, String password){
        Optional<Account> accountOpt = this.accountRepository.findByUsernameAndPassword(username, password);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return accountOpt.get();
    }


}
