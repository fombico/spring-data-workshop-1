package io.pivotal.spring.service;

import io.pivotal.spring.domain.User;
import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> {

    User findByNameAllIgnoringCase(String name);
}
