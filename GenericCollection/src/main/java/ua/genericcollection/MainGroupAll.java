package ua.genericcollection;

import java.math.BigInteger;

public class MainGroupAll {
    public static void main(String[] args) {
        GroupAll<BigInteger> gr = new GroupAll<>();
        gr.add(new BigInteger("125"));
        gr.add(new BigInteger("330"));

        System.out.println(gr.sum(100, new BigInteger("120")));

        GroupAll<String> gr2 = new GroupAll<>();
        gr2.add("Hello");
        System.out.println(gr.check(gr2));

    }
}
