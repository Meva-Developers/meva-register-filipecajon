package com.meva.finance.api.repository;

import com.meva.finance.api.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

   @Query(value = "SELECT id_family FROM family WHERE id_family = :id", nativeQuery = true)
   long findFamily(Long id);
}
