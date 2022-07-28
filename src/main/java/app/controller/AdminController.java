package app.controller;

import app.model.AppUser;
import app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping(value = {"/login"})
    public String getLoginPage() {
        return "login";
    }

    @PostMapping(value = {"/login"})
    public String login(AppUser myUser) {
        if (service.isCorrect(myUser.getUsername(), myUser.getPassword())) {
            return "successLogin";
        }

        return "notLogin";
    }

}
