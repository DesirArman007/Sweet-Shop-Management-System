package com.pm.sweetshopmanagementsystem.repositories;

import com.pm.sweetshopmanagementsystem.domain.entity.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface SweetRepository extends JpaRepository<Sweet, UUID> {

    List<Sweet> findByNameContainingIgnoreCase(String name);

    List<Sweet> findByCategoryIgnoreCase(String category);

    List<Sweet> findByPriceBetween(BigDecimal min, BigDecimal max);

}
