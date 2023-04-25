package kz.msovet.springmicroservice2.service.user;

import kz.msovet.springmicroservice2.model.User;
import kz.msovet.springmicroservice2.model.UserRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    Map<String, User> users;

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getFirstName());
        user.setSurname(userRequest.getLastName());

        if (users == null) users = new HashMap<>();

        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        users.put(userId, user);

        return user;
    }
}
