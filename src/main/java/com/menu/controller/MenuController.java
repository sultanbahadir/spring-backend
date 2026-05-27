package com.menu.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.menu.dto.MenuDTO;
import com.menu.dto.MenuItemDTO;
import com.menu.shared.IMenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    
    @PostMapping("/saveOrUpdate")
    public MenuDTO saveOrUpdate(@RequestBody MenuItemDTO request) {
        return menuService.saveorupdate(request);
    }

   
    @GetMapping("/get")
    public List<MenuDTO> getByDate(
            @RequestParam LocalDate date) {

        return menuService.getMenuByDate(date);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFood(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}