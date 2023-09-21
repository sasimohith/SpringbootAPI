package com.amdocs.springbootcasestudy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.springbootcasestudy.model.RouteEntity;


@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Integer> {

}
