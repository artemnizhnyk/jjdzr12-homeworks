package com.isa.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String surname;
    private Team team;
    public static List<Student> studentsList = new ArrayList<>();

    public Student(String firstName, String surname, Team team) {
        this.firstName = firstName;
        this.surname = surname;
        this.team = team;
    }

    public static void showInfoAboutStudents(List<Student> studentsList) {
        for (Student student : studentsList) {
            System.out.println(student.getFirstName() + " " +
                    student.getSurname() + " należy do zespołu " +
                    student.getTeam().getTeamName() + " który realizuje projekt o nazwie " +
                    student.getTeam().getProject().getProjectName() + ".");
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
