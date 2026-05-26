package shared;

import com.menu.dto.MenuDTO;
import java.time.LocalDate; 
import java.util.List; 

public interface MenuShared {

   public MenuDTO SaveOrUpdate(MenuDTO dto);
    
  List<MenuDTO> getMenuByDate(LocalDate date);
    
    List<MenuDTO> getAllMenus();
    
    void deleteMenu(Long id);
}
