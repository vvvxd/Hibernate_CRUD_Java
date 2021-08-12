package org.vvvxd.Hibernate_CRUD_Java.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository<T, ID> {

    T getById(ID id);

    List<T> getAll() throws SQLException;

    T save(T s);

    T update(T s);

    void deleteById(ID id);

}
