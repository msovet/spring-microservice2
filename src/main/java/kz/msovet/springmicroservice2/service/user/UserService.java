package kz.msovet.springmicroservice2.service.user;

import kz.msovet.springmicroservice2.model.User;
import kz.msovet.springmicroservice2.model.UserRequest;

public interface UserService {
    User createUser(UserRequest userRequest);
}
