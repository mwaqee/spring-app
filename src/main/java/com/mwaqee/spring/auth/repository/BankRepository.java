package com.mwaqee.spring.auth.repository;

import com.mwaqee.spring.auth.model.Bank;
import com.mwaqee.spring.auth.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByBankId(String bankId);
    Bank findByBankAccountNo(String bankAccountNo);
    Bank findByBankAccountTitle(String bankAccountTitle);
    Bank findByBankAccountType(String bankAccountType);
    Bank findByBankName(String bankName);
    Bank findByBankRoutingNo(String bankRoutingNo);
    void deleteBankByBankAccountNo(String bankAccountNo);
}
