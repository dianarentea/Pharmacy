package com.example.Pharmacy.controller;
import com.example.Pharmacy.dto.UserDto;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.reposiytory.UserRepository;
import com.example.Pharmacy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null) result.rejectValue("email", null, "User already registered");

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/login";
    }

    @GetMapping("/access-denied")
    @ResponseBody
    public String accessDenied(Model model) {
        return "Access denied";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?message=loggedOut";
    }

    @GetMapping("/forgot")
    public String loadForgotPassword(){
        return "forgot";
    }
    @GetMapping("/reset")
    public String loadResetPassword(){
        return "reset";
    }
    


}
