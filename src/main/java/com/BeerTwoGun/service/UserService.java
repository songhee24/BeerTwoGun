package com.BeerTwoGun.service;

import com.BeerTwoGun.entity.User;

public interface UserService extends BaseService<User> {
    User createUser(User user);

    User findByUserName(String userName);

    User login(User user);
}
