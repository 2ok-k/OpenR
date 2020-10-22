package com.miage.openrh.repositories;

import com.miage.openrh.models.Conge;
import com.miage.openrh.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
