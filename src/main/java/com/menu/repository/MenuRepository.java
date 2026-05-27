package com.menu.repository;

import org.aspectj.apache.bcel.generic.LineNumberGen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.menu.entities.MenuEntity;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

}
