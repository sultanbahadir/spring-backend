package com.menu.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menu.dto.MenuDTO;
import com.menu.dto.MenuItemDTO;
import com.menu.entities.MenuEntity;
import com.menu.entities.MenuItemEntity;
import com.menu.repository.MenuRepository;
import com.menu.shared.IMenuService;

@Service
public class MenuServices implements IMenuService {
	 
    @Autowired

    private MenuRepository repo;

    @Override
	public MenuDTO saveorupdate(MenuItemDTO dto) {

        MenuEntity entity;

        if (dto.getId() != null) {

            entity = repo.findById(dto.getId()).orElse(new MenuEntity());
        } else {

            entity = new MenuEntity();

        }

        entity.setPrice(dto.getPrice());
        entity.setStatus(dto.getStatus());
        entity.setDateCreated(dto.getDateCreated());
        entity.setStatus("1");
 
        MenuEntity savedEntity = repo.save(entity);

        return convertToDto(savedEntity);
    }
 
    @Override

    public void deleteMenu(Long id) {

        MenuEntity entity = repo.findById(id)

            .orElseThrow(() -> new NoSuchElementException("Menu bulunamadı"));

        entity.setStatus("0"); 

        repo.save(entity);

    }
 
    @Override
    public List<MenuDTO> getMenuByDate(LocalDate date) {

        List<MenuDTO> result = new ArrayList<>();

        List<MenuEntity> entities = repo.findByDateCreated(date);

        if (entities != null) {
            for (MenuEntity entity : entities) {
                result.add(convertToDto(entity));
            }
        }

        return result;
    }
    private MenuDTO convertToDto(MenuEntity entity) {
 
        MenuDTO dto = new MenuDTO();
        dto.setId(entity.getId());
        dto.setPrice(entity.getPrice());
        dto.setStatus(entity.getStatus());
        dto.setDateCreated(entity.getDateCreated());
        return dto;

    }}


  