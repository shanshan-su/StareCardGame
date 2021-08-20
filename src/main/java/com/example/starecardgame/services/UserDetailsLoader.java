package com.example.starecardgame.services;

import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.User;
import com.example.starecardgame.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private UsersRepository usersDao;

    public UserDetailsLoader(UsersRepository usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
        User user;
        if (input.contains("@")) {
            user = usersDao.findByEmail(input);
        } else {
            user = usersDao.findByUsername(input);
        }

        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + input);
        }

        return new UserWithRoles(user);
    }
}
