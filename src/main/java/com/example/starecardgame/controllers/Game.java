package com.example.starecardgame.controllers;

import com.example.starecardgame.daos.UsersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Game {
    private UsersRepository usersDao;

    public Game(UsersRepository usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping("/two-people-game")
    public String getTwoPeopleGameTable(Model model) {
        model.addAttribute("title", "Two People Game");
        return "game/twoPeopleGame";
    }
}
