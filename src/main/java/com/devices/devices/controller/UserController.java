package com.devices.devices.controller;

import com.devices.devices.dao.UserRepository;
import com.devices.devices.domain.User;
import com.devices.devices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("User", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("User") User user) {
        if (userRepository.findByUserName(user.getUserName()) == null){
            userService.save(user);
            return "redirect:/login";
        } else {
            return "redirect:/registration?existerror";
        }
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
