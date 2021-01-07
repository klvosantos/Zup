package com.zup.account.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zup.account.dto.UserDTO;
import com.zup.account.entities.User;
import com.zup.account.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	@Transactional
	public UserDTO insert(UserDTO dto) {		
		User user = new User(null, dto.getName(), dto.getEmail(), dto.getCpf(), dto.getBirthDate());
		user = repository.save(user);
		return new UserDTO(user);		
	}
}

