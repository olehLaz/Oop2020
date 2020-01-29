package ua.textcontainer;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@SaveToFile(str = "save2.txt")
public class TextContainer {
    private String st = "String  test text ";

    public TextContainer() {
    }

    @Saver
    public void save(String path) {
        File f = new File(path);
        if(f.isFile()){
            writeFile(f);
        } else {
            try {
                boolean createFile = f.createNewFile();
                if(createFile){
                    writeFile(f);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" Create file  " + f.getPath());
    }

    private void writeFile(File file) {
        try (FileWriter fr = new FileWriter(file)) {
            fr.write(st);
            fr.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}