package ua.comparator1;

import java.util.Comparator;

public class UsbDriveComparator implements Comparator<UsbDrive> {
    @Override
    public int compare(UsbDrive o1, UsbDrive o2) {
        if(o1.getRazm() > o2.getRazm()){
            return 1;
        }
        else  if (o1.getRazm() < o2.getRazm()) {
            return -1;
        }
        else return 0;
    }
}
