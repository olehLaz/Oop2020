package ua.comparator1;

public class UsbDrive {
    private int razm;
    private String name;

    public UsbDrive(int razm, String name) {
        this.razm = razm;
        this.name = name;
    }

    public int getRazm() {
        return razm;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UsbDrive{" +
                "razm=" + razm + " Gb " +
                ", name='" + name + '\'' +
                '}';
    }
}
