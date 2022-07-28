package app.controller;

import app.model.AppUser;
import app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService service;

    @GetMapping(value = {"/login"})
    public String getLoginPage(Model model) {
        model.addAttribute("myUser", new AppUser());
        return "login";
    }

    @PostMapping(value = {"/login"})
    public String login(AppUser myUser) {
        if (service.isCorrect(myUser.getUsername(), myUser.getPassword())) {
            return "redirect:/admin";
            // return "successLogin";
        }

        return "notLogin";
    }

    @GetMapping(value = {"/admin"})
    public String adminPage(Model model) {
        model.addAttribute("users", service.loadUsers());

        return "successLogin";
    }

    @GetMapping(value = {"/admin/{userId}"})
    public String oneUserPage(
            @PathVariable(name = "userId") long id,
            Model model) {
        List<AppUser> users = service.loadUsers();
        AppUser user = new AppUser();

        for (AppUser u : users) {
            if (u.getId() == id) {
                user = u;
                break;
            }
        }

        model.addAttribute("userId", user.getId());
        model.addAttribute("username", user.getUsername());

        return "appUsers";
    }

}
