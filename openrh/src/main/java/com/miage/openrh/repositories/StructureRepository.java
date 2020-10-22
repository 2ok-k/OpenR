package com.miage.openrh.repositories;

import com.miage.openrh.models.Conge;
import com.miage.openrh.models.Structure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StructureRepository extends JpaRepository<Structure, Integer> {
}
