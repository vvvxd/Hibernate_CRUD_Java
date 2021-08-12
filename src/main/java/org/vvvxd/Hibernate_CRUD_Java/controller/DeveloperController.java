package org.vvvxd.Hibernate_CRUD_Java.controller;

import org.vvvxd.Hibernate_CRUD_Java.model.Developer;
import org.vvvxd.Hibernate_CRUD_Java.model.Skill;
import org.vvvxd.Hibernate_CRUD_Java.DeveloperService;

import java.sql.SQLException;
import java.util.List;

public class DeveloperController {
    private final DeveloperService developerService = new DeveloperService();

    public Developer getById(Long id) {
        return developerService.getById(id);
    }

    public List<Developer> getAll() throws SQLException {
        return developerService.getAll();
    }

    public Developer save(String firstName, String lastName, List<Skill> skills, Long team) {
        return developerService.save(new Developer(firstName, lastName, skills, team));
    }

    public Developer update(Developer s) {
        return developerService.update(s);
    }

    public void deleteById(Long id) {
        developerService.deleteById(id);
    }
}
