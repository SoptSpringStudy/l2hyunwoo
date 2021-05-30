package kr.co.marubook.javaspringboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path = "/hello-world")
    public String getHelloWorldString() {
        return "HelloWorld";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldDto getHelloWorldDto() {
        return new HelloWorldDto("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path/{name}")
    public HelloWorldDto getHelloWorldWithName(@PathVariable String name) {
        return new HelloWorldDto(String.format("Hello, %s", name));
    }
}
