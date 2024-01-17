package guru.springframeworks.springrestclient.springrestclientexamples.services;

import guru.springframeworks.springrestclient.api.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiServicesImplTest {
    @Autowired
    ApiServices apiServices;
    @BeforeEach
    void setUp() throws Exception{
    }

    @Test
    public void testGetUser() throws Exception {
        List<User> users = apiServices.getUsers(10);
        assertEquals(10,users.size());
    }
}