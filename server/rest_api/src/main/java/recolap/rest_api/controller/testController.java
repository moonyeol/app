package recolap.rest_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @RequestMapping("/")
    public String index(){
        return "Hello!";
    }
}
