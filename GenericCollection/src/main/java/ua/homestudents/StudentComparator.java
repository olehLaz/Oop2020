package ua.homestudents;

import java.util.Comparator;

public class StudentComparator implements Comparator {
    private int i = 0;
    private boolean forward = true;

    public StudentComparator(int i) {
        super();
        this.i = i;
    }

    public StudentComparator(int i, boolean forward) {
        super();
        this.i = i;
        this.forward = forward;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public int compare(Object a, Object b) {

        int n = (this.forward) ? 1 : -1;

        if (a != null && b == null) {
            return 1;
        }
        if (a == null && b != null) {
            return -1;
        }
        if (a == null && b == null) {
            return 0;
        }
        Student s1 = (Student) a;
        Student s2 = (Student) b;
        switch (this.i) {
            case 0:
                return (s1.getAge() - s2.getAge()) * n;
            case 1:
                return (s1.getSurname().compareTo(s2.getSurname())) * n;
            case 2:
                return (s1.getName().compareTo(s2.getName())) * n;
            case 3:
                return (s1.getCourse() - s2.getCourse()) * n;
            case 4:
                return ((s1.getProgress() > s2.getProgress()) ? 1 : -1) * n;
        }
        return 0;
    }
}
