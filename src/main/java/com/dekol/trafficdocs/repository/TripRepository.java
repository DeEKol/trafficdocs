package com.dekol.trafficdocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dekol.trafficdocs.domain.TripEntity;

public interface TripRepository extends JpaRepository<TripEntity, Long> {

}
