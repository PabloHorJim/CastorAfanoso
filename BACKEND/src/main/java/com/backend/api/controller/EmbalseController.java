package com.backend.api.controller;

import com.backend.api.model.Embalse;
import com.backend.service.EmbalseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbalseController {
    EmbalseService service;

    @Autowired
    public EmbalseController(EmbalseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Embalse getPantanos(@RequestParam String x, String y, Integer dist){
        Optional<User> user = userService.getUserID(id);
        return user.isPresent()? user.get() : null;
    }
}
