package com.bngferoz.sqlaudit.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bngferoz.sqlaudit.entity.Name;

public interface NameRepo extends JpaRepository<Name, Integer>{

}
