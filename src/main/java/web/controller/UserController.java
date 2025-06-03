package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("users", allUsers);
        return "index";
    }

    @GetMapping("/saveUser")
    public String saveUsers(Model model) {
        model.addAttribute("user", new User());
        return "saveUser";
    }

    @PostMapping("/saveUser")
    public String saveUsers(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "saveUser";
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUsers(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
