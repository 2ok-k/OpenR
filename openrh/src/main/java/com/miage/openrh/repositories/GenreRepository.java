package com.miage.openrh.repositories;

import com.miage.openrh.models.Conge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Conge, Integer> {
}
