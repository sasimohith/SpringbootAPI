package com.amdocs.cargomanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.cargomanagement.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
