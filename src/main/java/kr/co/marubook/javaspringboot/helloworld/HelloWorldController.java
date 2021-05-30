package kr.co.marubook.javaspringboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String getHelloWorldString() {
        return "HelloWorld";
    }
}
