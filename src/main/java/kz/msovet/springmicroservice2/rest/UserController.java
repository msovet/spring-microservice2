package kz.msovet.springmicroservice2.rest;

import kz.msovet.springmicroservice2.model.User;
import kz.msovet.springmicroservice2.model.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping()
    private String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "100") int limit) {
        return "Called /api/users rest with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}")
    private ResponseEntity<User> getUser() {
        User user = new User();
        user.setId(123123123123L);
        user.setName("Maksat");
        user.setSurname("karabalin");

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping()
    private ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getFirstName());
        user.setSurname(userRequest.getLastName());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
