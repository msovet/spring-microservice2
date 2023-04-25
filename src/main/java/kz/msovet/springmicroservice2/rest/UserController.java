package kz.msovet.springmicroservice2.rest;

import jakarta.validation.Valid;
import kz.msovet.springmicroservice2.model.User;
import kz.msovet.springmicroservice2.model.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    Map<String, User> users;
    @GetMapping()
    private String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "100") int limit) {
        return "Called /api/users rest with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}")
    private ResponseEntity<User> getUser(@PathVariable String userId) {

        if (users.containsKey(userId)) {
            return new ResponseEntity<User>(users.get(userId), HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

    }

    @PostMapping()
    private ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getFirstName());
        user.setSurname(userRequest.getLastName());

        if (users == null) users = new HashMap<>();

        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        users.put(userId, user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
