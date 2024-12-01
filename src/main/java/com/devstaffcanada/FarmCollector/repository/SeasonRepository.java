package com.devstaffcanada.FarmCollector.repository;

import com.devstaffcanada.FarmCollector.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    Optional<Season> findByName(String name);
}

