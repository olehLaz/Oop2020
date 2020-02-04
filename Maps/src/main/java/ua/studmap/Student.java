package ua.studmap;

public class Student {
    private String FIO;
    private String facultet;
    private int cource;
    private double oc;

    public Student(String FIO, String facultet, int cource, double oc) {
        this.FIO = FIO;
        this.facultet = facultet;
        this.cource = cource;
        this.oc = oc;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("FIO='").append(FIO).append('\'');
        sb.append(", facultet=").append(facultet);
        sb.append(", cource=").append(cource);
        sb.append(", oc=").append(oc);
        sb.append('}');
        return sb.toString();
    }
}
