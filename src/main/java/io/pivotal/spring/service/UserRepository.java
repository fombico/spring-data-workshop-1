package io.pivotal.spring.service;

import io.pivotal.spring.domain.User;
import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, Long> {

    User findByNameAllIgnoringCase(String name);
}
