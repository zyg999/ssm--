package org.zyg.service;

import org.zyg.domain.User;

public interface UserService {
    User queryUser(String userName, String userPass);
    Integer addUser(User user);
}
