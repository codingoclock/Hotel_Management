package com.prakharSinghJPA.Hotel_Management.repository;

import com.prakharSinghJPA.Hotel_Management.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}