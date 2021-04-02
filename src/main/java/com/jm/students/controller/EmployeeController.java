package com.jm.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/client/employee")
public class EmployeeController {

    @GetMapping("newTicket")
    public String newOrder(Principal principal, Model model,
                           @ModelAttribute("text") String ticketText) {
        // --- Stub begin
        principal = () -> "TestEmployee";
        // --- Stub end
        String employeeName = principal.getName();
        model.addAttribute("employeeName", employeeName);
        return "client/employee/newTicket";
    }
}
