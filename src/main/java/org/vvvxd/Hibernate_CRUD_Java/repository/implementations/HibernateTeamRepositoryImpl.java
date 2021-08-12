package org.vvvxd.Hibernate_CRUD_Java.repository.implementations;


import org.hibernate.Session;
import org.vvvxd.Hibernate_CRUD_Java.model.Developer;
import org.vvvxd.Hibernate_CRUD_Java.model.Team;
import org.vvvxd.Hibernate_CRUD_Java.repository.TeamRepository;
import org.vvvxd.Hibernate_CRUD_Java.util.ConnectUtil;


import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class HibernateTeamRepositoryImpl implements TeamRepository {

    public List<Team> getAll() {
        List<Team> teams;
        try (Session session = ConnectUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Team d inner join fetch d.developers");
            teams = query.getResultList();
        } catch (NoResultException e) {
            teams = null;
        }
        return teams;
    }

    public Team getById(Long id) {
        Team team;
        try (Session session = ConnectUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Team d inner join fetch d.developers where d.id = :id");
            query.setParameter("id", id);
            team = (Team) query.getSingleResult();
        } catch (NoResultException e) {
            team = null;
        }
        return team;
    }


    public Team save(Team s) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();
        }
        return s;
    }

    public Team update(Team s) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(s);
            session.getTransaction().commit();
        }
        return s;
    }

    public void deleteById(Long id) {
        try(Session session = ConnectUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Team team = session.load(Team.class, id);
            session.delete(team);
            session.getTransaction().commit();
        }
    }
}
