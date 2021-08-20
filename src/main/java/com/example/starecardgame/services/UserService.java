package com.example.starecardgame.services;

import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UsersRepository usersDao;

    public UserService(UsersRepository usersDao) {
        this.usersDao = usersDao;
    }

    public User getLoggedInUser() {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersDao.findById(loggedInUser.getId()).get();
    }
}
