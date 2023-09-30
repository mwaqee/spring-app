package com.mwaqee.spring.auth.service;

import com.mwaqee.spring.auth.model.Employee;
import com.mwaqee.spring.auth.model.Role;
import com.mwaqee.spring.auth.repository.EmployeeRepository;
import com.mwaqee.spring.auth.repository.RoleRepository;
import com.mwaqee.spring.auth.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(Employee employee) {
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
        employeeRepository.save(employee);
    }

    @Override
    public Employee findByEmployeeId(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Employee findByEmployeeNo(String employeeNo) {
        return employeeRepository.findByEmployeeNo(employeeNo);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

	@Override
	public boolean validRoleId(String role) {
		boolean result = false;
		for(Role roleFromRepo : roleRepository.findAll()) {
			if(role.equals(roleFromRepo.getRoleId())) {
				result = true;
				break;
			}
		}
		return result;
	}
}
