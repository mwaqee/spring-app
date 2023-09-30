package com.mwaqee.spring.auth.service;

import com.mwaqee.spring.auth.model.Bank;
import com.mwaqee.spring.auth.model.Employee;
import com.mwaqee.spring.auth.model.Role;
import com.mwaqee.spring.auth.repository.BankRepository;
import com.mwaqee.spring.auth.repository.EmployeeRepository;
import com.mwaqee.spring.auth.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Bank bank) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	/*employee.setPassword(employee.getPassword());
        for(Role roleFromRepo : roleRepository.findAll()) {
        	if(Constants.CARDHOLDER_ROLE_ID.equals(roleFromRepo.getRoleId())) {
                employee.setUserRole(roleFromRepo);
				break;
			}
        }
        employee.setIsActive(Constants.YES);
        employee.setIsExpired(Constants.NO);
        employee.setIsLocked(Constants.NO);*/
        bankRepository.save(bank);
    }

    @Override
    public Bank findByBankId(String bankId) {

        return bankRepository.findByBankId(bankId);
    }

    @Override
    public Bank findByBankAccountNo(String bankAccountNo) {
        return bankRepository.findByBankAccountNo(bankAccountNo);
    }

    @Override
    public Bank findByBankAccountTitle(String bankAccountTitle) {
        return bankRepository.findByBankAccountTitle(bankAccountTitle);
    }

    @Override
    public Bank findByBankAccountType(String bankAccountType) {
        return bankRepository.findByBankAccountType(bankAccountType);
    }

    @Override
    public Bank findByBankName(String bankAccountName) {
        return bankRepository.findByBankName(bankAccountName);
    }

    @Override
    public Bank findByBankRoutingNo(String bankRoutingNo) {
        return bankRepository.findByBankRoutingNo(bankRoutingNo);
    }

    @Override
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    @Transactional
    public void deleteBankByBankAccountNo(String bankAccountNo){
        bankRepository.deleteBankByBankAccountNo(bankAccountNo);
    }
}
