package ru.gb.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.users.repo.User;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @PostMapping
    public User newUser(@RequestBody User user) {
        return userService.newUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
