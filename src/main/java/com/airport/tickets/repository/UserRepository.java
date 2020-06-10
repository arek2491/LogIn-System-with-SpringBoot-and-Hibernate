package com.airport.tickets.repository;

import com.airport.tickets.domain.User;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    Set<User> findAll();

    @Override
    Optional<User> findById(Long userId);

    @Override
    User save(User user);

    @Override
    void deleteById(Long userId);

}
