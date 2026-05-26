package com.menu.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.entities.MenuEntity;
import com.menu.entities.MenuItemEntity;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Long> {

	List<MenuItemEntity> findByDateCreated(LocalDate date);
	List<MenuItemEntity> findByStatusAndDateCreated(String status, LocalDate date);
	boolean existsByMenuAndCategory(MenuEntity menu, Category category);
}
