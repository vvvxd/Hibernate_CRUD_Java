package org.vvvxd.Hibernate_CRUD_Java.repository.implementations;


import org.hibernate.Session;
import org.vvvxd.Hibernate_CRUD_Java.model.Developer;
import org.vvvxd.Hibernate_CRUD_Java.model.Skill;
import org.vvvxd.Hibernate_CRUD_Java.repository.DeveloperRepository;
import org.vvvxd.Hibernate_CRUD_Java.util.ConnectUtil;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateDeveloperRepositoryImpl implements DeveloperRepository {

    public Developer getById(Long id) {
        Developer developer;
        try (Session session = ConnectUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Developer d inner join fetch d.skills where d.id = :id");
            query.setParameter("id", id);
            developer = (Developer) query.getSingleResult();
        } catch (NoResultException e) {
            developer = null;
        }
        return developer;
    }

    public List<Developer> getAll() {
        List<Developer> developers;
        try (Session session = ConnectUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Developer d inner join fetch d.skills");
            developers = query.getResultList();
        } catch (NoResultException e) {
            developers = null;
        }
        return developers;
    }

    @Override
    public Developer save(Developer s) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
        }
        return s;
    }

    @Override
    public Developer update(Developer s) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
           // Developer developer = session.load(Developer.class, s.getId());
            session.update(s);
            session.getTransaction().commit();
        }
        return s;
    }

    public void deleteById(Long id) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Developer developer = session.load(Developer.class, id);
            session.delete(developer);
            session.getTransaction().commit();
        }
    }

}
