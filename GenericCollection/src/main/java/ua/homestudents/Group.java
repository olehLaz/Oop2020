package ua.homestudents;

import java.io.Serializable;
import java.util.Arrays;

public class Group implements Voencom, Serializable {
    private static final long serialVersionUID = 1L;
    private Student[] s = new Student[10];
    private String groupName;

    public Group() {
        super();
        this.groupName = "unknow";
    }

    public Group(String groupName) {
        super();
        this.groupName = groupName;
    }

    public Student[] getS() {
        return s;
    }

    public void setS(Student[] s) {
        this.s = s;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) throws MyException {
        if (student == null) {
            throw new IllegalArgumentException("Null student");
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                s[i] = student;
                return;
            }
        }
        throw new MyException();
    }

    public Student searchStudent(String surName) {
        for (Student student : s) {
            if (student != null && student.getSurname().equals(surName)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int course) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != null && s[i].getCourse() == course) {
                Student st = s[i];
                s[i] = null;
                System.out.println(st.toString() + " was successfully deleted." + '\n');
                return;
            }
        }
    }

    private void sort() {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (compareStudent(s[i], s[j]) > 0) {
                    Student temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
                }
            }
        }
    }

    private int compareStudent(Student a, Student b) {
        if (a != null && b == null) {
            return 1;
        }
        if (a == null && b != null) {
            return -1;
        }
        if (a == null && b == null) {
            return 0;
        }
        return a.getSurname().compareTo(b.getSurname());
    }

    public void sortByParametr(int i) {
        Arrays.sort(this.s, new StudentComparator(i));
    }

    public void sortByParametr(int i, boolean forward) {
        Arrays.sort(this.s, new StudentComparator(i, forward));
    }

    public Student[] getStudentArray() {
        Student[] temp = new Student[this.s.length];
        System.arraycopy(s, 0, temp, 0, temp.length);
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group: ").append(System.lineSeparator());
        int i = 0;
        sort();
        for (Student student : s) {
            if (student != null) {
                sb.append((++i) + ") ").append(student);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public Student[] getRecruter() {
        int n = 0;
        for (Student student : s) {
            if (student != null && student.getAge() >= 18) {
                n += 1;
            }
        }
        Student[] recruterArray = new Student[n]; // n - количество студентов в массиве
        int i = 0;
        for (Student student : this.s) {
            if (student != null && student.getAge() >= 18) {
                recruterArray[i++] = student;
            }
        }
        return recruterArray;
    }
}
