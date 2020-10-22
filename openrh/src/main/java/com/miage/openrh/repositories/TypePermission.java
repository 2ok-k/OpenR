package com.miage.openrh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePermission extends JpaRepository<TypePermission, Integer> {
}
