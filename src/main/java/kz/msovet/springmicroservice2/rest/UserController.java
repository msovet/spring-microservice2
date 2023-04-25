package kz.msovet.springmicroservice2.rest;

import jakarta.validation.Valid;
import kz.msovet.springmicroservice2.model.User;
import kz.msovet.springmicroservice2.model.UserRequest;
import kz.msovet.springmicroservice2.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

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
        User user = userService.createUser(userRequest);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    private ResponseEntity<String> deleteUser(@PathVariable String userId) {
        users.get(userId);
        users.remove(userId);

        return new ResponseEntity<>("Deleted Entity", HttpStatus.OK);
    }
}
