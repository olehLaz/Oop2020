package ua.sort1;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainArrays {
    public static final Logger logger = Logger.getLogger(MainArrays.class.getName());



    static Integer[] toSort = new Integer[]
                { 5, 1, 89, 255, 7, 88, 200, 123, 66};
       int[]  sortedInts = new int[]
                {1, 5, 7, 66, 88, 89, 123, 200, 255};
       int[] sortedRangeInts = new int[]
                {5, 1, 89, 7, 88, 200, 255, 123, 66};

    public static void main(String[] args) {

      //  Arrays.sort(toSort);
        for (int i =0; i<toSort.length; i++)
        System.out.print(toSort[i] + "   ");
        System.out.println();

        Arrays.sort(toSort, 3, 7);
        for (int i =0; i<toSort.length; i++) {
         //   System.out.print(toSort[i] + "   ");
     //       logger.log(Level.INFO, "Found {0} ", toSort[i]);
            logger.info("toSort[" + i + "] = " + toSort[i]);

        }
        System.out.println();
        System.out.println("----------------------");

        List<Integer> toSortList = Arrays.asList(toSort);
        Collections.sort(toSortList);
        System.out.println(toSortList);
        logger.info(toSortList.toString());

        System.out.println("-------set---------------");
        Set<Integer> integersSet = new LinkedHashSet<>(Arrays.asList(toSort));
        System.out.println(integersSet);
        Set<Integer> descSortedIntegersSet = new LinkedHashSet<>(
                Arrays.asList(new Integer[]
                        {255, 200, 123, 89, 88, 66, 7, 5, 1, 777}));
        System.out.println("descSortedIntegersSet = " + descSortedIntegersSet);

        List<Integer> list = new ArrayList<Integer>(integersSet);
        Collections.sort(list, (i1, i2) -> {
            return i2 - i1;
        });
        integersSet = new LinkedHashSet<>(list);
        System.out.println(integersSet);



    }


}
