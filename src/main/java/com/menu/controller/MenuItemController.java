package com.menu.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.menu.dto.MenuItemDTO;
import com.menu.services.MenuItemServices;


@RestController
@RequestMapping("/api/menus")
public class MenuItemController {

    @Autowired
    private MenuItemServices services;

    @PostMapping("/saveOrUpdate")
    public MenuItemDTO saveOrUpdate(@RequestBody MenuItemDTO request) {
        return services.SaveOrUpdate(request);
    }

    @GetMapping("/get")
    public List<MenuItemDTO> getByDate( @RequestParam LocalDate date) {
        return services.getMenuByDate(date);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFood(@PathVariable Long id) {
    	services.deleteMenu(id);
    }
}