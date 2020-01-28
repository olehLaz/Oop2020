package ua.arraytolist;



import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainArrayAndList {
    public static void main(String[] args) {
        List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
        Integer[]targetArray = sourceList.toArray(new Integer[sourceList.size()]);

        Integer[]sourceArray = { 0, 1, 2, 3, 4, 5 };
        List<Integer> targetList = Arrays.asList(sourceArray);
        //или
        Integer[]sourceArray1 = { 0, 1, 2, 3, 4, 5, null };
        List<Integer> targetList1 = new ArrayList<Integer>(Arrays.asList(sourceArray1));

        for (Integer in : sourceArray1) //если int Exception in thread "main" java.lang.NullPointerException
            System.out.print("  " + in);
        System.out.println();
        System.out.println("-----------");
        int[] arr = new int[]{5, 7, 5, 6, 85, 45, 6, 0};
        for (Integer in : arr)
                System.out.print("  " + in);
        System.out.println();
        System.out.println("---------------");
        Arrays.sort(arr);
        for (Integer in : arr)
            System.out.print("  " + in);




    }
}
