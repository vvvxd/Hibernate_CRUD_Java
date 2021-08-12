package org.vvvxd.Hibernate_CRUD_Java.model;

import javax.persistence.*;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "id_developer")
    private Long idDeveloper;

    public void setId(Long id) {
        this.id = id;
    }



    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Skill( String name, Long idDeveloper) {
        this.id = 0L;
        this.name = name;
        this.idDeveloper = idDeveloper;
    }

    public Skill() {
    }

    public Long getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(Long idDeveloper) {
        this.idDeveloper = idDeveloper;
    }

    public Skill(Long id, String name, Long idDeveloper) {
        this.id = id;
        this.name = name;
        this.idDeveloper = idDeveloper;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
