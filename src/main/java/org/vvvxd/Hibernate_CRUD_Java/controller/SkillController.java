package org.vvvxd.Hibernate_CRUD_Java.controller;

import org.vvvxd.Hibernate_CRUD_Java.model.Skill;
import org.vvvxd.Hibernate_CRUD_Java.SkillService;

import java.util.List;

public class SkillController {
    private final SkillService skillService = new SkillService();

    public Skill getById(Long id) {
        return skillService.getById(id);
    }

    public List<Skill> getAll() {
        return skillService.getAll();
    }

    public Skill save(String name, Long developerId) {
        return skillService.save(new Skill(name, developerId));
    }

    public Skill update(Skill s) {
        return skillService.update(s);
    }

    public void deleteById(Long id) {
        skillService.deleteById(id);
    }
}
