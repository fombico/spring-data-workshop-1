package io.pivotal.spring.service;

import io.pivotal.spring.domain.User;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @After
    public void teardown() {
        userService.deleteAll();
    }

    @Test
    public void insertsUsers() {
        assertThat(userService.getAddress("fred")).isNull();

        userService.insertOrUpdate(new User("fred", "toronto"));

        assertThat(userService.getAddress("fred")).isEqualTo("toronto");
    }

    @Test
    public void updatesUsers() {
        User user = userService.insertOrUpdate(new User("fred", "toronto"));
        assertThat(userService.getAddress("fred")).isEqualTo("toronto");

        user.setAddress("vancouver");
        userService.insertOrUpdate(user);
        assertThat(userService.getAddress("fred")).isEqualTo("vancouver");
    }

    @Test
    public void deletesUsers() {
        User user = userService.insertOrUpdate(new User("fred", "toronto"));
        assertThat(user).isNotNull();

        userService.delete(user);
        assertThat(userService.getAddress("fred")).isNull();
    }

    @Test
    public void deletesAll() {
        userService.insertOrUpdate(new User("fred", "toronto"));
        userService.insertOrUpdate(new User("john", "toronto"));

        assertThat(userService.getAddress("fred")).isNotNull();
        assertThat(userService.getAddress("john")).isNotNull();

        userService.deleteAll();

        assertThat(userService.getAddress("fred")).isNull();
        assertThat(userService.getAddress("john")).isNull();
    }

    @Test
    public void getAddressReturnsAddress_whenGivenName() {
        userService.insertOrUpdate(new User("fred", "toronto"));

        String address = userService.getAddress("fred");
        assertThat(address).isEqualTo("toronto");
    }

    @Test
    public void getAddressReturnsNull_whenNameNotFound() {
        assertThat(userService.getAddress("fred")).isNull();
    }
}