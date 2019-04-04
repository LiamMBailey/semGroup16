package com.napier.sem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class AppController {

    @RequestMapping("/api/hello")
    public String helloworld(){
        return "aye Mate.";
    }


}
