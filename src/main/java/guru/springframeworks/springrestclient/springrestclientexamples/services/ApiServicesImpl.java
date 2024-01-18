package guru.springframeworks.springrestclient.springrestclientexamples.services;

import guru.springframeworks.springrestclient.api.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@Service
public class ApiServicesImpl implements ApiServices{
    private RestTemplate restTemplate;
    private final String api_url;

    public ApiServicesImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public List<User> getUsers(Integer limit) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(api_url)
                .queryParam("limit",limit);
        List<User> userData = restTemplate.getForObject(uriBuilder.toUriString(), List.class);
        return userData;
    }
}
