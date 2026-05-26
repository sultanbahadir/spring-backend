package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.menu.dto.MenuDTO;
import com.menu.entities.MenuEntity;
import com.menu.repository.MenuRepository;

import shared.MenuShared;

@Service
public class MenuServices implements MenuShared {

    @Autowired
    private MenuRepository repo;

	@Override
	public MenuDTO SaveOrUpdate(MenuDTO dto) {
		 MenuEntity entity;
	        
	        if (dto.getId() != null) {
	            entity = repo.findById(dto.getId()).orElse(new MenuEntity());
	        } else {
	            entity = new MenuEntity();
	            entity.setDateCreated(LocalDate.now());
	            entity.setStatus("1");
	        }
	        entity.setName(dto.getName());
	        entity.setPrice(dto.getPrice());
	        entity.setCategory(dto.getCategory());
	        
	        MenuEntity savedEntity = repo.save(entity);
	        return convertToDto(savedEntity);
	    	}

	@Override
	public List<MenuDTO> getMenuByDate(LocalDate date) {

	    List<MenuDTO> result = new ArrayList<>();

	    for (MenuEntity menu : repo.findByStatusAndDateCreated("1", date)) {
	        result.add(convertToDto(menu));
	    }

	    return result;
	}
	@Override
	public List<MenuDTO> getAllMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMenu(Long id) {
		 MenuEntity entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException("Menu bulunamadı"));
		    
		        entity.setStatus("0");
		        repo.save(entity);
		    }		
	
		private MenuDTO convertToDto(MenuEntity entity) {

		    MenuDTO dto = new MenuDTO();

		    dto.setId(entity.getId());
		    dto.setName(entity.getName());
		    dto.setCategory(entity.getCategory());
		    dto.setPrice(entity.getPrice());
		    dto.setStatus(entity.getStatus());
		    dto.setDateCreated(entity.getDateCreated());
		    dto.setDateUpdated(entity.getDateUpdated());

		    return dto;
		}}