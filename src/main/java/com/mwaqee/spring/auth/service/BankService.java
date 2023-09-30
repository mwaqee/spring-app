package com.mwaqee.spring.auth.service;

import com.mwaqee.spring.auth.model.Bank;
import com.mwaqee.spring.auth.model.Employee;

import java.util.List;

public interface BankService {
    void save(Bank bank);
    Bank findByBankId(String bankId);
    Bank findByBankAccountNo(String bankAccountNo);
    Bank findByBankAccountTitle(String bankAccountTitle);
    Bank findByBankAccountType(String bankAccountType);
    Bank findByBankName(String bankName);
    Bank findByBankRoutingNo(String bankRoutingNo);
    List<Bank> getAllBanks();
    void deleteBankByBankAccountNo(String bankAccountNo);
}
