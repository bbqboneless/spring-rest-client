package guru.springframeworks.springrestclient.springrestclientexamples.services;

import guru.springframeworks.springrestclient.api.domain.User;

import java.util.List;

public interface ApiServices {
    List<User> getUsers(Integer limit);
}
