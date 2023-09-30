package com.mwaqee.spring.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwaqee.spring.auth.model.Role;
import com.mwaqee.spring.auth.model.User;
import com.mwaqee.spring.auth.repository.RoleRepository;
import com.mwaqee.spring.auth.repository.UserRepository;
import com.mwaqee.spring.auth.utils.Constants;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	user.setPassword(user.getPassword());
        for(Role roleFromRepo : roleRepository.findAll()) {
        	if(Constants.CARDHOLDER_ROLE_ID.equals(roleFromRepo.getRoleId())) {
				user.setUserRole(roleFromRepo);
				break;
			}
        }
        user.setIsActive(Constants.YES);
        user.setIsExpired(Constants.NO);
        user.setIsLocked(Constants.NO);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserId(username);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
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
