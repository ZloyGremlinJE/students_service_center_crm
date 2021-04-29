package com.jm.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestSecurityController {

    @GetMapping("/director_page")
    public String getDirectorPage() {
        return "testSecurityTemplates/test_security_director";
    }

    @GetMapping("/manager_page")
    public String getManagerPage() {
        return "service_requests_for_manager";
    }

    @GetMapping("/engineer_page")
    public String getEngineerPage() {
        return "testSecurityTemplates/test_security_engineer";
    }
}
