package com.vilaka.saveentityassociateforone.repositories;

import com.vilaka.saveentityassociateforone.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
