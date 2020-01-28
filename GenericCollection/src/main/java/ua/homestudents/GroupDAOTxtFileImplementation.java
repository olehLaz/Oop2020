package ua.homestudents;

import java.io.*;

public class GroupDAOTxtFileImplementation implements GroupDAO {
    private File folder;

    public GroupDAOTxtFileImplementation(File folder) {
        super();
        this.folder = folder;
    }

    public GroupDAOTxtFileImplementation() {
        super();
    }

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    @Override
    public void saveGroup(Group group) {
        try (PrintWriter pw = new PrintWriter(new File(folder, group.getGroupName() + ".txt"))) {
            for (Student student : group.getS()) {
                if (student != null) {
                    pw.println(student.getAge() + "," + student.getSurname() + "," + student.getName() + ","
                            + student.getCourse() + "," + student.getProgress());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Group loadGroupByName(String groupName) {
        Group groupR = new Group(groupName);
        try (BufferedReader br = new BufferedReader(new FileReader(new File(folder, groupName + ".txt")))) {
            String text = "";
            for (; (text = br.readLine()) != null;) {
                String[] studentDate = text.split(",");
                int age = Integer.valueOf(studentDate[0]);
                String surname = studentDate[1];
                String name = studentDate[2];
                int course = Integer.valueOf(studentDate[3]);
                int progress = Integer.valueOf(studentDate[4]);
                Student student = new Student(age, surname, name, course, progress);
                groupR.addStudent(student);

            }
        } catch (IOException | MyException e) {
            System.out.println(e);
            return null;
        }
        return groupR;
    }
}
