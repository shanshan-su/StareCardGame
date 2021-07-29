package com.example.starecardgame.controllers;

import com.example.starecardgame.daos.UsersRepository;
import com.example.starecardgame.models.User;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private UsersRepository usersDao;
//    private PasswordEncoder passwordEncoder;

    public UserController(UsersRepository usersDao) {
        this.usersDao = usersDao;
//        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {

        model.addAttribute("title", "Stare Card Game Home");
        return "home";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("title", "Signup");
        model.addAttribute("user", new User());
        return "users/signupLogin";
    }
}
