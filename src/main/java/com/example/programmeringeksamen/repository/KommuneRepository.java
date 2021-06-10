package com.example.programmeringeksamen.repository;

import com.example.programmeringeksamen.model.Kommune;
import org.springframework.data.repository.CrudRepository;

//Repository extends CrudRepository which contains standard create, read, readall, update and delete methods
public interface KommuneRepository extends CrudRepository<Kommune, Long> {
}
