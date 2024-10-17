package com.backend.api.controller;

import com.backend.service.pantanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmbalseController {
    pantanoService service;

    @Autowired
    public EmbalseController(pantanoService service) {
        this.service = service;
    }


}
