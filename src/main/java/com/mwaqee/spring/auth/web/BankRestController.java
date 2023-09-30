package com.mwaqee.spring.auth.web;

import com.mwaqee.spring.auth.model.Bank;
import com.mwaqee.spring.auth.model.Employee;
import com.mwaqee.spring.auth.service.BankService;
import com.mwaqee.spring.auth.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankRestController {
    @Autowired
    private BankService bankService;

    @GetMapping("/rest/bank/getAllBanks")
    //Returning List is supported with JSON response only
    //If you want XML, then add a wrapper class as Root XML element, for example EmployeeList
    // Returns all banks
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    @GetMapping("/rest/bank/deleteBankByBankAccountNo")
    // This method deletes bank by bank account no
    public void deleteBankByBankAccountNo(String bankAccountNo) {
        bankService.deleteBankByBankAccountNo(bankAccountNo);
    }
}
