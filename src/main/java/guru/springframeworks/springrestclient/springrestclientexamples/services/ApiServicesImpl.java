package guru.springframeworks.springrestclient.springrestclientexamples.services;

import guru.springframeworks.springrestclient.api.domain.User;
import guru.springframeworks.springrestclient.api.domain.UserData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ApiServicesImpl implements ApiServices{
    private RestTemplate restTemplate;
    public ApiServicesImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public List<User> getUsers(Integer limit) {
        List<User> userData = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users?limit=" + limit, List.class);
        return userData;
    }
}
