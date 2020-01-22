package ua.genericcollection;

import java.io.*;

public class SaveAndLoadToFile {
    public static GroupCat loadFromFile(String File) {
        File f = new File(File);
        GroupCat groupCat = new GroupCat();
        try (FileReader fr = new FileReader(f);
             BufferedReader buf = new BufferedReader(fr)) {
            String str = "";
            for (; (str = buf.readLine()) != null; ) {
                String[] str1 = str.split(",");
                groupCat.add(new Cat(str1[0], Integer.valueOf(str1[1]), str1[2], Boolean.valueOf(str1[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + "groupCat is loaded from File "+ f + "\n");
        return groupCat;
    }

    public static void saveToFile(GroupCat groupCat) {
        File file = new File("cats.txt");
        try(BufferedWriter bufwt = new BufferedWriter(new FileWriter(file))) {
            for (Cat cats : groupCat.getCats()) {
                if(cats != null) {
                    bufwt.write(cats.getName() + "," + cats.getAge() + "," + cats.getColor() +
                            "," + cats.isSex());
                    bufwt.newLine();
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n" + "groupCat is saved to File Cats.txt" + "\n");
    }
}
