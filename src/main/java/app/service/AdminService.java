package app.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {

    private Map<String, String> registeredUsers;

    public AdminService() {
        registeredUsers = new HashMap<>();
    }

    public boolean isCorrect(String username, String password) {
        return username.equals("admin") && password.equals("abc123");
    }

    public void register(String username, String pass) {
        registeredUsers.put(username, pass);
    }

    public boolean isRegisteredOk(String username, String pass) {
        return registeredUsers.get(username).equals(pass);
    }

}
