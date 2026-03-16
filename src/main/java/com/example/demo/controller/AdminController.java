package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

@RestController
public class AdminController {

    @Autowired
    private AdminService eser;

    @PostMapping("/addadmin")
    public Admin regAdmin(@RequestBody Admin admin) {
        return eser.addAdmin(admin);
    }

    @GetMapping("/getadmin")
    public List<Admin> getAdmin() {
        return eser.getAdmin();
    }

    @PutMapping("/updateadmin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return eser.updateAdmin(admin);
    }

    @DeleteMapping("/deleteadmin/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        eser.deleteAdmin(id);
    }
    
    @GetMapping("/searchadmin/{name}")
    public List<Admin> searchAdmin(@PathVariable String name)
    {
        return eser.searchAdmin(name);
    }
}