package com.NIED.controller;

import com.NIED.model.AdminUser;
import com.NIED.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    @Autowired
     private AdminUserService adminUserService;

    @PostMapping("/register")
    public ResponseEntity<AdminUser> registerAdmin(@RequestBody AdminUser adminUser) {
        
        AdminUser newAdminUser = adminUserService.createAdminUser(adminUser);
        return new ResponseEntity<>(newAdminUser, HttpStatus.CREATED);
    }
}