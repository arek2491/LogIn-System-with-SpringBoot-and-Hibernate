package com.airport.tickets.mapper;

import com.airport.tickets.domain.User;
import com.airport.tickets.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getLogin(), user.getEmail(), user.getPassword());
    }

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getId(), userDto.getFirstName(), userDto.getLastName(), userDto.getLogin(), userDto.getEmail(), userDto.getPassword());
    }

    public Set<UserDto> mapToUserDtoList(final Set<User> users) {
        return users.stream()
                .map(i -> new UserDto(i.getId(), i.getFirstName(), i.getLastName(), i.getLogin(), i.getEmail(), i.getPassword()))
                .collect(Collectors.toSet());
    }
}
