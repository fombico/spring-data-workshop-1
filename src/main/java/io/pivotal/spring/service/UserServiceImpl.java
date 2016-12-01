package io.pivotal.spring.service;

import io.pivotal.spring.domain.User;
import org.springframework.stereotype.Component;

@Component
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User insertOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user.getId());
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public String getAddress(String name) {
        User user = userRepository.findByNameAllIgnoringCase(name);
        return user == null ? null : user.getAddress();
    }

}
