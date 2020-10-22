package com.miage.openrh.repositories;

import com.miage.openrh.models.Conge;
import com.miage.openrh.models.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysRepository extends JpaRepository<Pays, Integer> {
}
