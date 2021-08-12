package org.vvvxd.Hibernate_CRUD_Java.repository;

import org.vvvxd.Hibernate_CRUD_Java.model.Team;

import java.util.List;

public interface TeamRepository extends GenericRepository<Team,Long> {
    Team getById(Long id);

    List<Team> getAll();

    Team save(Team s);

    Team update(Team s);

    void deleteById(Long id);
}
