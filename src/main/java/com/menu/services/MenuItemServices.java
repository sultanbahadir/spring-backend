package com.menu.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.menu.dto.MenuItemDTO;
import com.menu.entities.MenuEntity;
import com.menu.entities.MenuItemEntity;
import com.menu.repository.MenuItemRepository;
import com.menu.repository.MenuRepository;
import com.menu.shared.MenuItemShared;

@Service
public class MenuItemServices implements MenuItemShared {

    @Autowired
    private MenuItemRepository repo;

    @Autowired
    private MenuRepository menuRepository;
	@Override
	public MenuItemDTO SaveOrUpdate(MenuItemDTO dto) {
		
		MenuEntity menu = menuRepository.findById(dto.getId())
	            .orElseThrow(() -> new RuntimeException("Menu bulunamadı"));
		 MenuItemEntity entity;
	        
	        if (dto.getId() != null) {
	            entity = repo.findById(dto.getId()).orElse(new MenuItemEntity());
	        } else {
	        	
	        	 if (repo.existsByMenuAndCategory(menu, dto.getCategory())) {
	                 throw new RuntimeException("Bu menüde bu category zaten var");
	             }
	            entity = new MenuItemEntity();
	            entity.setDateCreated(LocalDate.now());
	            entity.setStatus("1");
	        }
	        entity.setName(dto.getName());
	        entity.setPrice(dto.getPrice());
	        entity.setCategory(dto.getCategory());
	        
	        MenuItemEntity savedEntity = repo.save(entity);
	        return convertToDto(savedEntity);
	    	}
	
	@Override
	public List<MenuItemDTO> getMenuByDate(LocalDate date) {

	    List<MenuItemDTO> result = new ArrayList<>();

	    for (MenuItemEntity menu : repo.findByStatusAndDateCreated("1", date)) {
	        result.add(convertToDto(menu));
	    }

	    return result;
	}
	@Override
	public List<MenuItemDTO> getAllMenus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMenu(Long id) {
		 MenuItemEntity entity = repo.findById(id).orElseThrow(() -> new NoSuchElementException("Menu bulunamadı"));
		    
		        entity.setStatus("0");
		        repo.save(entity);
		    }		
	
		private MenuItemDTO convertToDto(MenuItemEntity entity) {

		    MenuItemDTO dto = new MenuItemDTO();

		    dto.setId(entity.getId());
		    dto.setName(entity.getName());
		    dto.setCategory(entity.getCategory());
		    dto.setPrice(entity.getPrice());
		    dto.setStatus(entity.getStatus());
		    dto.setDateCreated(entity.getDateCreated());
		    dto.setDateUpdated(entity.getDateUpdated());

		    return dto;
		}}