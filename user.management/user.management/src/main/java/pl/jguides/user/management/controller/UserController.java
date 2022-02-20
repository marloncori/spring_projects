package pl.jguides.user.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.jguides.user.management.error.UserAlreadySavedException;
import pl.jguides.user.management.error.UserNotFoundException;
import pl.jguides.user.management.model.User;
import pl.jguides.user.management.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private String success = "The user has been successfully saved!";

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String showUserList(Model model) throws UserNotFoundException {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add a new user");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redAttr) throws UserAlreadySavedException {
        userService.addUser(user);
        redAttr.addFlashAttribute("message", success);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes redAttr) throws Exception {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
        return "user_form";
    }

    @PostMapping("/users/save/{id}")
    public String updateUser(@PathVariable("id") Integer id, User user, RedirectAttributes redAttr) throws UserNotFoundException {
        userService.updateUser(user, id);
        redAttr.addFlashAttribute("message", success);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redAttr) throws UserNotFoundException {
        userService.deleteUser(id);
        redAttr.addFlashAttribute("message", "The user with ID # " + id + " has been deleted.");
        return "redirect:/users";
    }
}
