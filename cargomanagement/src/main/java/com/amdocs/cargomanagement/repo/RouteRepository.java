package com.amdocs.cargomanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.cargomanagement.model.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {
}
