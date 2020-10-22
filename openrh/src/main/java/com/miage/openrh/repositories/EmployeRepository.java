package com.miage.openrh.repositories;

import com.miage.openrh.models.Conge;
import com.miage.openrh.models.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, String> {
}
