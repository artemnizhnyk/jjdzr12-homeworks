package com.isa.bootcamp;

public class Student {
    private String firstName;
    private String surname;
    private Team team;

    public Student(String firstName, String surname, Team team) {
        this.firstName = firstName;
        this.surname = surname;
        this.team = team;
    }

    public void showInfoAboutStudent() {
        System.out.println(this.getFirstName() + " " +
                this.getSurname() + " należy do zespołu " +
                this.getTeam().getTeamName() + " który realizuje projekt o nazwie " +
                this.getTeam().getProject().getProjectName() + ".");
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
