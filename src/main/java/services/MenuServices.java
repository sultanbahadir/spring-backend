package services;

import com.menu.dto.MenuDTO;
import com.menu.entities.MenuEntity;
import com.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;
import shared.MenuShared;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServices implements MenuShared {

    private final MenuRepository repo;

    public MenuServices(MenuRepository menuRepository) {
        this.repo = menuRepository;
    }

    @Override
    public MenuDTO SaveOrUpdate(MenuDTO dto) {

        MenuEntity menu = repo.findById(dto.getId() != null ? dto.getId() : 0L)
                .orElse(new MenuEntity());

        menu.setId(dto.getId());
        menu.setCategory(dto.getCategory());
        menu.setName(dto.getName());
        menu.setPrice(dto.getPrice());
        menu.setStatus(dto.getStatus());

        if (menu.getId() == null) {
            menu.setDateCreated(LocalDateTime.now());
        } else {
            menu.setDateCreated(dto.getDateCreated());
        }
        menu.setDateUpdated(java.sql.Date.valueOf(LocalDate.now()));

        MenuEntity saved = repo.save(menu);

        return convert(saved);
    }

    @Override
    public MenuDTO getMenuByDate(LocalDate date) {

        for (MenuEntity menu : repo.findAll()) {
            if (menu.getDateCreated() != null && 
                menu.getDateCreated().toLocalDate().isEqual(date) && 
                "1".equals(menu.getStatus())) {
                
                return convert(menu);
            }
        }

        return new MenuDTO();
    }

    @Override
    public List<MenuDTO> getAllMenus() {

        List<MenuDTO> dtoList = new ArrayList<>();

        for (MenuEntity menu : repo.findAll()) {
            dtoList.add(convert(menu));
        }

        return dtoList;
    }

    @Override
    public void deleteMenu(Long id) {

        MenuEntity menu = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Menu bulunamadı"));

        menu.setStatus("0"); 
        repo.save(menu);
    }

    private MenuDTO convert(MenuEntity menu) {

        if (menu == null) {
            return null;
        }

        MenuDTO menuDto = new MenuDTO();

        menuDto.setId(menu.getId());
        menuDto.setCategory(menu.getCategory());
        menuDto.setName(menu.getName());
        menuDto.setPrice(menu.getPrice());
        menuDto.setStatus(menu.getStatus());
        menuDto.setDateCreated(menu.getDateCreated());
        menuDto.setDateUpdated(menu.getDateUpdated());

        return menuDto;
    }
}