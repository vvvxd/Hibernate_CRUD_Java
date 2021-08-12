package org.vvvxd.Hibernate_CRUD_Java;


import org.vvvxd.Hibernate_CRUD_Java.model.Skill;
import org.vvvxd.Hibernate_CRUD_Java.repository.SkillRepository;
import org.vvvxd.Hibernate_CRUD_Java.repository.implementations.HibernateSkillRepositoryImpl;

import java.util.List;

public class SkillService {
    private final SkillRepository skillRepository= new HibernateSkillRepositoryImpl();

    public Skill getById(Long id) {
        return skillRepository.getById(id);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill update(Skill s) {
        return skillRepository.update(s);
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }
}
