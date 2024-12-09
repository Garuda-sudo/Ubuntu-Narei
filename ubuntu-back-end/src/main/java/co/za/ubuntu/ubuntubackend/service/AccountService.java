package co.za.ubuntu.ubuntubackend.service;


import co.za.ubuntu.model.Account;

public interface AccountService {

    void createAccount(Account accountDTO);
    Account getAccount(Integer accountId);
    Account updateAccount(Account accountDTO);
    void deleteAccount(Integer accountId);

}
