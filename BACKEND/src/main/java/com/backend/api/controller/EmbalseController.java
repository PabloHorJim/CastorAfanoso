package com.backend.api.controller;

import com.backend.api.model.Embalse;
import com.backend.service.EmbalseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmbalseController {
    EmbalseService service;

    @Autowired
    public EmbalseController(EmbalseService service){
        this.service = service;
    }

    /**
     * URL para la peticion http://localhost:8080/?x=valorX&y=valorY&dist=dist
     * @param x
     * @param y
     * @param dist
     * @return
     */
    @GetMapping("/")
    public ResponseEntity<List<Embalse>> getPantanos(@RequestParam String x, String y, Integer dist){
        List<Embalse> embalses = EmbalseService.getFromDist(x,y,dist);
        if (embalses.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.ok(embalses);
    }
}
