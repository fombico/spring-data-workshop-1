package io.pivotal.spring.service;

import io.pivotal.spring.domain.User;

public interface UserService {

    User insertOrUpdate(User user);

    String getAddress(String name);

    void delete(User user);

    void deleteAll();
}
