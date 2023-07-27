package com.isa.bootcamp;

public class Team {
    private String teamName;
    private int countOfTeamMembers;
    private Project project;

    public Team(String teamName, int countOfTeamMembers, Project project) {
        this.teamName = teamName;
        this.countOfTeamMembers = countOfTeamMembers;
        this.project = project;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getCountOfTeamMembers() {
        return countOfTeamMembers;
    }

    public void setCountOfTeamMembers(int countOfTeamMembers) {
        this.countOfTeamMembers = countOfTeamMembers;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
