package com.Secuirty.secuirtyproject.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    @GetMapping
    public ResponseEntity<String>SayHello(){
        return ResponseEntity.ok("Hello from admin");
    }
}
