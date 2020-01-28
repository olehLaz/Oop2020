package ua.serializable1;

import java.io.*;

public class MainRectangle1 {
    public static void main(String[] args) {
        Rectangle rectOne = new Rectangle(10,12);
        try (FileOutputStream fos = new FileOutputStream("ab.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos);){
            oos.writeObject(rectOne);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Rectangle rectFive = new Rectangle();
        try(FileInputStream fis = new FileInputStream("ab.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            rectFive = (Rectangle) ois.readObject();

        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("  rectFive " + rectFive);


    }
}
