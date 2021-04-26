package com.jm.students.controller;

import com.jm.students.model.Role;
import com.jm.students.model.User;
import com.jm.students.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;



@Controller
public class AddUserController {

    private UserService userService;

    @Autowired
    public AddUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/adduser")
    public String addUserClient(ModelMap model, Principal principal) throws Exception {
        List<Role> roles = new ArrayList<>();
        User user = userService.findUserByEmail(principal.getName());
        switch (user.getRole()) {
            case DIRECTOR:
                roles.add(Role.ENGINEER);
                roles.add(Role.MANAGER);
                model.addAttribute("roles", roles);
                model.addAttribute("organizationId", user.getOrganization().getId());
                break;

            case CLIENT_DIRECTOR:
                roles.add(Role.CLIENT_EMPLOYEE);
                model.addAttribute("roles", roles);
                model.addAttribute("organizationId", user.getOrganization().getId());
                break;

            default:
                throw new Exception();
        }
        return "addnewuser/addNewUser";
    }

}
