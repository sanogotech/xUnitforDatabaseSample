package com.logicbig.example;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Transactional
    @Procedure(procedureName = "MOVE_TO_HISTORY")
    boolean movePersonToHistory(@Param("person_id_in") int personId);
}