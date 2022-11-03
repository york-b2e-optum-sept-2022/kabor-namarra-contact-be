package net.yorksolutions.contactsbe.controller;

import net.yorksolutions.contactsbe.DTO.NewAccountRequestDTO;
import net.yorksolutions.contactsbe.entity.Account;
import net.yorksolutions.contactsbe.services.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account create(@RequestBody NewAccountRequestDTO requestDTO){
        return this.accountService.createAccount(requestDTO);
    }

    @GetMapping
    public Account login(@RequestParam String username, @RequestParam String password){
        return this.accountService.loginAccount(username, password);
    }
}
