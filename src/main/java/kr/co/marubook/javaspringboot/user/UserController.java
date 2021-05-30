package kr.co.marubook.javaspringboot.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public User retrieveUser(@PathVariable Integer id) throws UserNotFoundException {
        return service.fetchUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = service.save(user);
        // URI는 자원의 저장 장소, 즉 End Point를 가리킴
        // 이는 Header를 통해 내려온다
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        // ResponseEntity.created는 201 status code와 함께 전달된다.
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
