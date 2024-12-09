package co.za.ubuntu.ubuntubackend.service.impl;

import co.za.ubuntu.model.Account;
import co.za.ubuntu.ubuntubackend.persistence.repository.AccountRepository;
import co.za.ubuntu.ubuntubackend.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Override
    public void createAccount(Account accountDTO) {

    }

    @Override
    public Account getAccount(Integer accountId) {
        return null;
    }

    @Override
    public Account updateAccount(Account accountDTO) {
        return null;
    }

    @Override
    public void deleteAccount(Integer accountId) {

    }
}
