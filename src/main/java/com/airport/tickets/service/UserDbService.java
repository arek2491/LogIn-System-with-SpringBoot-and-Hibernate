package com.airport.tickets.service;

import com.airport.tickets.domain.User;
import com.airport.tickets.domain.UserNotFoundException;
import com.airport.tickets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserDbService {

    @Autowired
    private UserRepository userRepository;

    public Set<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(final Long userId) throws UserNotFoundException {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long userId) {
        userRepository.deleteById(userId);
    }
}
