package com.isa.bootcamp;



public class BootcampApp {
    public static void main(String[] args) {

        Project firstProject = new Project("The first project", "Any description of the first project", true);
        Project secondProject = new Project("The second project", "Any description of the second project", true);

        Team firstTeam = new Team("FirstTeam", 2,firstProject);
        Team secondTeam = new Team("SecondTeam", 2, secondProject);

        Student student1 = new Student("Artem", "Nizhnyk",firstTeam);
        Student student2 = new Student("Gleb", "Zubov", firstTeam);
        Student student3 = new Student("Daniel", "Matvievsky", secondTeam);
        Student student4 = new Student("Vlad", "Ivanov", secondTeam);

        student1.showInfoAboutStudent();
        student2.showInfoAboutStudent();
        student3.showInfoAboutStudent();
        student4.showInfoAboutStudent();

    }
}
