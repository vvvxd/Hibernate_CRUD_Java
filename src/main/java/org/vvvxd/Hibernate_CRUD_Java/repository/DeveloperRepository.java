package org.vvvxd.Hibernate_CRUD_Java.repository;


import org.vvvxd.Hibernate_CRUD_Java.model.Developer;

import java.sql.SQLException;
import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer,Long>{
    Developer getById(Long id);

    List<Developer> getAll() throws SQLException;

    Developer save(Developer s);

    void deleteById(Long id);

    Developer update(Developer s);
}
