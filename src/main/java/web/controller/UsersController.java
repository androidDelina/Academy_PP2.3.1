package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.ServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    private ServiceImpl service;

    @Autowired
    public UsersController(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("users", service.getAllUsers());
        return "users";
    }

    @PostMapping()
    public String createUser(@ModelAttribute User user) {
        service.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String addNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @GetMapping("/user")
    public String getUserById(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "user";
    }

    @PostMapping("/user/edit")
    public String updateUser(@ModelAttribute User user) {
        service.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/user")
    public String deleteUser(@RequestParam("id") int id) {
        service.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user/edit")
    public String getEditForm(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "editUser";
    }
}
