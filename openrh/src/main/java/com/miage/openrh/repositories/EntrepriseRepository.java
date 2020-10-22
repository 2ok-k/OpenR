package com.miage.openrh.repositories;

import com.miage.openrh.models.Conge;
import com.miage.openrh.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
