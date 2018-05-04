package com.answers.finallesson;

import com.answers.finallesson.domain.User;
import com.answers.finallesson.repository.UserRepository;
import com.answers.finallesson.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserTest {
    @Autowired
    private UserService userService;

    @Before
    public void before() {
        userService.clear();
    }

    @Test
    public void testSaveGetUser() {
        User user = new User();
        user.setEmail("test_user");
        user.setName("Name");
        user.setLastName("LastName");
        user.setPassword("pass");
        user.setActive(1);

        userService.saveUser(user);

        User obtained = userService.findUserByEmail("test_user");

        Assert.assertNotNull(obtained);
        Assert.assertEquals(user.getEmail(), obtained.getEmail());
    }
}
