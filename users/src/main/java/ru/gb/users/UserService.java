package ru.gb.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.users.repo.User;
import ru.gb.users.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User updateUser(Long id, User user) {
        Optional<User> checkUser = userRepo.findById(id);
        if (checkUser.isEmpty()) {
            return null;
        }
        User existingUser = checkUser.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return userRepo.save(existingUser);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public User findById(Long id) {
        Optional<User> checkUser = userRepo.findById(id);
        return checkUser.orElse(null);
    }

    public Boolean delete(Long id) {
        Optional<User> checkUser = userRepo.findById(id);
        if (checkUser.isEmpty()) {
            return false;
        }
        userRepo.deleteById(id);
        return true;
    }

    public User newUser(User user) {
        return userRepo.save(user);
    }
}
