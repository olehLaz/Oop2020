package ua.comparator1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class MainUsbDrive {
    public static void main(String[] args) {
        TreeSet<UsbDrive> usbDriveTreeSet = new TreeSet<UsbDrive>(new UsbDriveComparator());
            usbDriveTreeSet.add(new UsbDrive(28, "Kingston"));
            usbDriveTreeSet.add(new UsbDrive(16, "Transdent"));
            usbDriveTreeSet.add(new UsbDrive(4, "Apach"));

        System.out.println(usbDriveTreeSet);
        Iterator<UsbDrive> itr = usbDriveTreeSet.iterator();
        for (;itr.hasNext();){
            System.out.println(itr.next());
        }

        Comparator<UsbDrive> usbDriveComparator = Comparator.comparing(UsbDrive::getName,
                (a,b) -> a.compareTo(b));
        TreeSet<UsbDrive> usbDriveTreeSet1 = new TreeSet<UsbDrive>(usbDriveComparator);
        usbDriveTreeSet1.add(new UsbDrive(28, "Kingston"));
        usbDriveTreeSet1.add(new UsbDrive(16, "Transdent"));
        usbDriveTreeSet1.add(new UsbDrive(4, "Apach"));
        System.out.println("---------------getName----------------");


        Iterator<UsbDrive> itr1 = usbDriveTreeSet1.iterator();
        for (;itr1.hasNext();){
            System.out.println(itr1.next());
        }
    }
}
