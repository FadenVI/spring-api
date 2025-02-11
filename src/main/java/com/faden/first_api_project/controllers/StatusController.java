package com.faden.first_api_project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @GetMapping
    public String initialiazeAPI() {
        return "API funcionando";
    }
}
