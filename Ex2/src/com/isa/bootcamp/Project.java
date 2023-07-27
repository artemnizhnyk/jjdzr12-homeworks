package com.isa.bootcamp;

public class Project {
    private String projectName;
    private String projectDescription;
    private boolean isActiveProject;

    public Project(String projectName, String projectDescription, boolean isActiveProject) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.isActiveProject = isActiveProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public boolean isActiveProject() {
        return isActiveProject;
    }

    public void setActiveProject(boolean activeProject) {
        isActiveProject = activeProject;
    }
}
