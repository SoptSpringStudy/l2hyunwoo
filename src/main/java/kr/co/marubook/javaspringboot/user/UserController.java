package kr.co.marubook.javaspringboot.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

// GET /users -> 모든 User들
// GET /users/{id} -> 해당 id의 user
@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.fetchAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable Integer id) {
        return service.fetchUser(id);
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody User user) {
        return service.save(user);
    }
}
