package com.anhnt.repository;

import com.anhnt.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer>, CrudRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findAll();

    @Query("select c from EmployeeEntity c where c.name like %?1%")
    Page<List<EmployeeEntity>> findAllByName(String name, Pageable pageable);

}
