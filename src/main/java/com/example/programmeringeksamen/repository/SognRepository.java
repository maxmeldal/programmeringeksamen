package com.example.programmeringeksamen.repository;

import com.example.programmeringeksamen.model.Sogn;
import org.springframework.data.repository.CrudRepository;

//Repository extends CrudRepository which contains standard create, read, readall, update and delete methods

public interface SognRepository extends CrudRepository<Sogn, Long> {
}
