package ua.homestack;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        BlackList bl = new BlackList();
        bl.addClassToList(Integer.class);
        stack.setBlackList(bl);
        stack.addElement(new File("a.txt"));
        stack.addElement(new Scanner(System.in));
        stack.addElement(new BigInteger("99999"));
        stack.addElement(new Integer("100"));
        stack.addElement(12345);
        stack.addElement(true);
        System.out.println("------stack----------");
        System.out.println(stack);
        System.out.println("----------------");
        for (; stack.getLastElement() != null;) {
            System.out.println(stack.getLastElementAndDel());
        }

        System.out.println();
        System.out.println(stack.getLastElementAndDel());
    }
}
