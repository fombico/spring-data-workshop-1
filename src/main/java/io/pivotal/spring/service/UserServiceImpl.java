package io.pivotal.spring.service;

import org.springframework.stereotype.Component;

@Component
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String getAddress(String name) {
        return userRepository.findByNameAllIgnoringCase(name).getAddress();
    }

}
