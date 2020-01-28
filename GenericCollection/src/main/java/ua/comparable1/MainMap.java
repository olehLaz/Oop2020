package ua.comparable1;

import java.util.*;
import java.util.logging.Logger;

public class MainMap {
    public static final Logger logger = Logger.getLogger(MainMap.class.getName());

    public static HashMap<Integer, String> initVariables() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(55, "John");
        map.put(22, "Apple");
        map.put(66, "Earl");
        map.put(77, "Pearl");
        map.put(12, "George");
        map.put(6, "Rocky");
        return map;
    }
    public static Map<Integer, String> givenMap__whenSortingByKeys__thenSortedMap(HashMap<Integer, String> map) {
        Integer[] sortedKeys = new Integer[]{6, 12, 22, 55, 66, 77};

        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(
                    Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();
        map = initVariables();
        System.out.println(map);
        logger.info(map.toString());
        System.out.println();
        map = givenMap__whenSortingByKeys__thenSortedMap(initVariables());
        System.out.println(map);
        logger.info(map.toString());
        System.out.println();
        System.out.println("-------------------------------------");
        map = givenMap__whenSortingByValues__thenSortedMap(initVariables());
        logger.info(map.toString());
    }

    public static Map<Integer, String> givenMap__whenSortingByValues__thenSortedMap(HashMap<Integer, String> map) {
        List<Map.Entry<Integer, String>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(
                    Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<Integer, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }



}
