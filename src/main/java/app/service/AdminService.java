package app.service;

import app.model.AppUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Value("${custom.username}")
    private String username;

    @Value("${custom.userPassword}")
    private String pw;

    public AdminService() {}

    public boolean isCorrect(String username, String password) {
        return username.equals(this.username) && password.equals(this.pw);
    }

    public List<AppUser> loadUsers() {
        List<AppUser> users = new ArrayList<>();

        users.add(new AppUser(33, "Béla", "bela"));
        users.add(new AppUser(66, "Jukundusz", "jukundusz"));

        return users;
    }

}
