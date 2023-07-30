package com.isa.bootcamp;


public class BootcampApp {
    public static void main(String[] args) {

        Project firstProject = new Project("The first project", "Any description of the first project", true);
        Project secondProject = new Project("The second project", "Any description of the second project", true);

        Team firstTeam = new Team("FirstTeam", 2, firstProject);
        Team secondTeam = new Team("SecondTeam", 2, secondProject);

        Student.studentsList.add(new Student("Artem", "Nizhnyk", firstTeam));
        Student.studentsList.add(new Student("Gleb", "Zubov", firstTeam));
        Student.studentsList.add(new Student("Daniel", "Matvievsky", secondTeam));
        Student.studentsList.add(new Student("Vlad", "Ivanov", secondTeam));

        Student.showInfoAboutStudents(Student.studentsList);

    }
}
