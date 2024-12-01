package com.devstaffcanada.FarmCollector.repository;

import com.devstaffcanada.FarmCollector.entity.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
    Optional<Farm> findByName(String name);
}

