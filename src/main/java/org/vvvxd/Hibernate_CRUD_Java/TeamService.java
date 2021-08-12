package org.vvvxd.Hibernate_CRUD_Java;

import org.vvvxd.Hibernate_CRUD_Java.model.Team;
import org.vvvxd.Hibernate_CRUD_Java.repository.implementations.HibernateTeamRepositoryImpl;

import java.util.List;

public class TeamService {
    private final org.vvvxd.Hibernate_CRUD_Java.repository.TeamRepository TeamRepository = new HibernateTeamRepositoryImpl();

    public Team getById(Long id) {
        return TeamRepository.getById(id);
    }

    public List<Team> getAll() {
        return TeamRepository.getAll();
    }

    public Team save(Team team) {
        return TeamRepository.save(team);
    }

    public Team update(Team s) {
        return TeamRepository.update(s);
    }

    public void deleteById(Long id) {
        TeamRepository.deleteById(id);
    }
}
