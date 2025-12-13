package com.pm.sweetshopmanagementsystem.repositories;

import com.pm.sweetshopmanagementsystem.domain.entity.Sweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SweetRepository extends JpaRepository<Sweet, UUID> {
}
