package org.vvvxd.Hibernate_CRUD_Java.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_developer")
    private Long id;

    @Column(name = "id_team")
    private Long idTeam;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "idDeveloper")
    private List<Skill> skills;


    public Developer(Long id, Long idTeam, String firstName, String lastName, List<Skill> skills) {
        this.id = id;
        this.idTeam = idTeam;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public Developer(Long id, String firstName, String lastName, List<Skill> skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
    }

    public Developer(String firstName, String lastName, List<Skill> skills,Long idTeam) {
        this.id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.idTeam = idTeam;
    }

    public Developer() {
        this.id = 0L;
        this.firstName = "";
        this.lastName = "";
        this.skills = new ArrayList<Skill>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                '}';
    }
}
