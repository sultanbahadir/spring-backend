package controller;

import com.menu.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MenuServices;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = "*") 
public class MenuController {

    @Autowired
    private MenuServices menuService;

    @PostMapping("/saveOrUpdate")
    public MenuDTO saveOrUpdate(@RequestBody MenuDTO request) {
        return menuService.SaveOrUpdate(request); 
    }

    @GetMapping("/get")
    public MenuDTO getByDate(@RequestParam LocalDate date) {
        return menuService.getMenuByDate(date);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteFood(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }
}