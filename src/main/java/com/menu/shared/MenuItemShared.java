package com.menu.shared;

import com.menu.dto.MenuItemDTO;
import java.time.LocalDate; 
import java.util.List; 

public interface MenuItemShared {

   public MenuItemDTO saveOrUpdate(MenuItemDTO dto);
    
  List<MenuItemDTO> getMenuByDate(LocalDate date);
    
    List<MenuItemDTO> getAllMenus();
    
    void deleteMenu(Long id);
}
