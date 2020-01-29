package ua.reflection1;

import java.io.FileWriter;
import java.io.IOException;

@SaveTo (path="file.txt")
public class TextContainer {


    private String str = "Something";

    @Saver

    public void save(String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write(str);
        fw.close();

    }
}
