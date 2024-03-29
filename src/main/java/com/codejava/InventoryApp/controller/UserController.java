package com.codejava.InventoryApp.controller;

import com.codejava.InventoryApp.dto.UserRegistrationDTO;
import com.codejava.InventoryApp.model.Role;
import com.codejava.InventoryApp.model.User;
import com.codejava.InventoryApp.service.IRoleService;
import com.codejava.InventoryApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @GetMapping(value = {"", "/"})
    public String listUsers(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/new")
    public String showNewUserForm(Model model) {
        User user = new User();
        List<Role> roleList = roleService.getAllRoles();

        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "user_form";
    }

    @GetMapping("/registration")
    public String showUserRegistrationForm(Model model) {
        UserRegistrationDTO user = new UserRegistrationDTO();

        model.addAttribute("user", user);
        return "user_registration_form";
    }

    @PostMapping("/save")
    public String saveUser(Model model, @Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Role> roleList = roleService.getAllRoles();
            model.addAttribute("roleList", roleList);

            return "user_form";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute("user") UserRegistrationDTO user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_registration_form";
        }
        userService.saveUserRegistration(user);
        return "redirect:/users/registration?success";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(Model model, @PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        List<Role> roleList = roleService.getAllRoles();

        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
