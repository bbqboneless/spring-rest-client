package guru.springframeworks.springrestclient.springrestclientexamples.controllers;

import guru.springframeworks.springrestclient.springrestclientexamples.services.ApiServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
@Slf4j
@Controller
public class UserController {
    private ApiServices apiService;

    public UserController(ApiServices apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){

        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        Integer limit = Integer.valueOf(map.get("limit").get(0));

        log.debug("Received Limit value: " + limit);
        //default if null or zero
        if(limit == null || limit == 0){
            log.debug("Setting limit to default of 10");
            limit = 10;
        }

        model.addAttribute("users", apiService.getUsers(limit));

        return "userlist";
    }
}
