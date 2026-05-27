package com.menu.shared;

import java.time.LocalDate;
import java.util.List;

import com.menu.dto.MenuDTO;
import com.menu.dto.MenuItemDTO; // Eğer MenuItemDTO yerine MenuDTO kullanacaksan burayı ona göre düzenle

public interface IMenuService {

	MenuDTO saveorupdate(MenuItemDTO request);

	List<MenuDTO> getMenuByDate(LocalDate date);

	void deleteMenu(Long id);}