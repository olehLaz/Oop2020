package ua.genericcollection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GroupCat {
    private List<Cat> catList = new ArrayList<>();

    public GroupCat() {
    }

    public GroupCat(List<Cat> catList) {
        this.catList = catList;
    }

    public List<Cat> getCats() {
        return catList;
    }

    @Override
    public String toString() {
        return "GroupCat{" +
                "catList=" + catList +
                '}';
    }

    public void add(Cat cat) {
        this.catList.add(cat);
    }
}
