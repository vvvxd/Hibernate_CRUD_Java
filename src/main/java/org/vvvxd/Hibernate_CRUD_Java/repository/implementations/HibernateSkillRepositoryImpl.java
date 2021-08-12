package org.vvvxd.Hibernate_CRUD_Java.repository.implementations;


import org.hibernate.Session;
import org.vvvxd.Hibernate_CRUD_Java.model.Developer;
import org.vvvxd.Hibernate_CRUD_Java.model.Skill;
import org.vvvxd.Hibernate_CRUD_Java.repository.SkillRepository;
import org.vvvxd.Hibernate_CRUD_Java.util.ConnectUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class HibernateSkillRepositoryImpl implements SkillRepository {

    public Skill getById(Long id) {
        Skill skill;
        try (Session session = ConnectUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Skill d  where d.id = :id");
            query.setParameter("id", id);
            skill = (Skill) query.getSingleResult();
        } catch (NoResultException e) {
            skill = null;
        }
        return skill;
    }

    public List<Skill> getAll() {
        List<Skill> skills;
        try (Session session = ConnectUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Skill");
            skills = query.getResultList();
        } catch (NoResultException e) {
            skills = null;
        }
        return skills;
    }

    public Skill save(Skill skill) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(skill);
            session.getTransaction().commit();
        }
        return skill;
    }

    public Skill update(Skill skill) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            // Developer developer = session.load(Developer.class, s.getId());
            session.update(skill);
            session.getTransaction().commit();
        }
        return skill;
    }

    public void deleteById(Long id) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Skill skill = session.load(Skill.class, id);
            session.delete(skill);
            session.getTransaction().commit();
        }
    }

}
