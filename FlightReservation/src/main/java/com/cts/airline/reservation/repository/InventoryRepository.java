package com.cts.airline.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.airline.reservation.entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{
}
