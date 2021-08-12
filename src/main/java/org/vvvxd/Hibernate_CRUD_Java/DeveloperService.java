package org.vvvxd.Hibernate_CRUD_Java;


import org.vvvxd.Hibernate_CRUD_Java.model.Developer;
import org.vvvxd.Hibernate_CRUD_Java.repository.DeveloperRepository;
import org.vvvxd.Hibernate_CRUD_Java.repository.implementations.HibernateDeveloperRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class DeveloperService {
    private final DeveloperRepository DeveloperRepository = new HibernateDeveloperRepositoryImpl();

    public Developer getById(Long id) {
        return DeveloperRepository.getById(id);
    }

    public List<Developer> getAll() throws SQLException {
        return DeveloperRepository.getAll();
    }

    public Developer save(Developer dev) {
        return DeveloperRepository.save(dev);
    }

    public Developer update(Developer s) {
        return DeveloperRepository.update(s);
    }

    public void deleteById(Long id) {
        DeveloperRepository.deleteById(id);
    }
}
