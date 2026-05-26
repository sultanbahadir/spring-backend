package shared;

import com.menu.dto.MenuDTO;
import java.time.LocalDate; 
import java.util.List; 

public interface MenuShared {

    MenuDTO SaveOrUpdate(MenuDTO dto);
    
    MenuDTO getMenuByDate(LocalDate date);
    
    List<MenuDTO> getAllMenus(); // -> Tüm menüleri liste halinde dönecek yeni metot
    
    void deleteMenu(Long id);
}