package com.backend.api.controller;

import com.backend.service.pantanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PantanoController {
    pantanoService service;

    @Autowired
    public PantanoController(pantanoService service) {
        this.service = service;
    }


}
