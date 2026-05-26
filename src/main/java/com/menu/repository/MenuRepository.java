package com.menu.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.entities.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

	List<MenuEntity> findByDateCreated(LocalDate date);
	List<MenuEntity> findByStatusAndDateCreated(String status, LocalDate date);

}
