package org.vvvxd.Hibernate_CRUD_Java.view;

import org.vvvxd.Hibernate_CRUD_Java.controller.DeveloperController;
import org.vvvxd.Hibernate_CRUD_Java.controller.SkillController;
import org.vvvxd.Hibernate_CRUD_Java.model.Developer;
import org.vvvxd.Hibernate_CRUD_Java.model.Skill;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    private final DeveloperController DeveloperController = new DeveloperController();
    Scanner scanner = new Scanner(System.in);

    public void save() throws SQLException {
        System.out.println("Enter the first name of the Developer: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter the last name of the Developer: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter the team of the Developer: ");
        TeamView teamView = new TeamView();
        teamView.getAll();
        Long team = Long.parseLong(scanner.nextLine());
        List<Skill> skills = enterSkill();
        if (!lastName.isEmpty() && !firstName.isEmpty()) {
            Developer developer = DeveloperController.save(firstName, lastName, skills, team);
            System.out.println(developer.toString());
        }
    }

    public void getAll() {
        try {
            List<Developer> DeveloperList;
            DeveloperList = DeveloperController.getAll();
            if (DeveloperList.isEmpty()) {
                System.out.println("There are no Developers.");
                return;
            }
            for (Developer i : DeveloperList) {
                System.out.println(i.toString());
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("There are no Developers.");
        }
    }

    public void getById(Long id) {
        try {
            List<Developer> DeveloperList;
            Developer Developer;
            DeveloperList = DeveloperController.getAll();
            if (DeveloperList.isEmpty()) {
                System.out.println("There are no Developers.");
                return;
            }
            Developer = DeveloperController.getById(id);
            System.out.println(Developer.toString());
        } catch (NumberFormatException | SQLException e) {
            System.out.println("There are no Developers.");
        }
    }

    public void update(Long id) {
        try {
            System.out.println("Enter the first name of the Developer: ");
            String firstName = scanner.nextLine();
            System.out.println("Enter the last name of the Developer: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter the team of the Developer: ");
            TeamView teamView = new TeamView();
            teamView.getAll();
            Long team = Long.parseLong(scanner.nextLine());
            List<Skill> skills = enterSkill();
            if (!lastName.isEmpty() && !firstName.isEmpty()) {
                Developer developer = DeveloperController.update(new Developer(id, team, firstName, lastName, skills));
                System.out.println(developer.toString());
            }
        } catch (NumberFormatException | SQLException exception) {
            System.out.println("Wrong id or name.");
        }
    }

    public void deleteById(Long id) {
        try {
            List<Developer> DeveloperList;
            DeveloperList = DeveloperController.getAll();
            if (DeveloperList.isEmpty()) {
                System.out.println("Write correct id.");
                return;
            }
            DeveloperController.deleteById(id);
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Write correct id.");
        }
    }

    public void runner() throws SQLException {
        menu();
        selectMenu();
    }

    private void menu() {
        System.out.println("\n*** DEVELOPER MENU ***");
        System.out.println(" ================================= ");
        System.out.println("Choose next action:");
        System.out.println("1. Save\n2. Get all\n3. Get by id\n4. Update\n5. DeleteById\n6. RETURN");
    }

    private void selectMenu() throws SQLException {
        String input;
        scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            if (input.equals("1")) {
                save();
            } else if (input.equals("2")) {
                getAll();
            } else if (input.equals("3")) {
                System.out.println("Enter id");
                Long num = Long.parseLong(scanner.nextLine());
                getById(num);
            } else if (input.equals("4")) {
                System.out.println("Enter id");
                Long num = Long.parseLong(scanner.nextLine());
                update(num);
            } else if (input.equals("5")) {
                System.out.println("Enter id");
                Long num = Long.parseLong(scanner.nextLine());
                deleteById(num);
            } else if (input.equals("6")) {
                break;
            } else {
                System.out.println("Please, enter numbers from 1 to 6");
                menu();
            }
        }
    }
    private List<Skill> enterSkill() throws SQLException {
        String result;
        List<Skill> skills = new ArrayList<>();
        System.out.println("Enter the developer of the Team (Y - if the developer to be added; N - if not):");
        SkillController skillController = new SkillController();
        List<Skill> skillList = skillController.getAll();
        for (Skill skill : skillList) {
            System.out.println(skill.toString());
            result = scanner.nextLine();
            if (result.equals("Y")) {
                skills.add(skill);
            }
        }
        return skills;
    }

}
