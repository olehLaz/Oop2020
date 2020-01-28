package ua.homestudents;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Group g1 = new Group("101");
        try {
            g1.addStudent(new Student(15, "C", "Serg", 1, 1256));
            g1.addStudent(new Student(16, "B", "Max", 2, 2574));
            g1.addStudent(new Student(17, "M", "Michael", 3, 2441));
            g1.addStudent(new Student(18, "D", "Vadim", 4, 2001));
            g1.addStudent(new Student(19, "S", "Vlad", 5, 1965));
            g1.addStudent(new Student(20, "F", "Serg", 6, 1100));
            g1.addStudent(new Student(21, "G", "Max", 7, 3001));
            g1.addStudent(new Student(22, "H", "Michael", 8, 2369));
            g1.addStudent(new Student(23, "L", "Vadim", 9, 2555));
            g1.addStudent(new Student(24, "A", "Vlad", 10, 1001));
            System.out.println(g1);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

        File folder = new File("GROUPfolder");
        folder.mkdirs();

        GroupDAO groupDAO = new GroupDAOSerializableImplementation(folder);
        GroupController controller = new GroupController(groupDAO);
        controller.saveGroup(g1);
        System.out.println();
        Group g2 = controller.loadGroupByName("101");
        System.out.println(g2);
    }
}
