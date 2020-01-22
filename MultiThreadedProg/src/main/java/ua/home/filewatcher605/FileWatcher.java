package ua.home.filewatcher605;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;



public class FileWatcher {
    private File mainFolder;
    private File[] currentFileArray;
    private File[] previousFileArray;

    public static boolean flag = true;

    public FileWatcher(File mainFolder) {
        this.mainFolder = mainFolder;
        previousFileArray = this.mainFolder.listFiles();
    }

    public File getMainFolder() {
        return mainFolder;
    }

    private String getFolderInfo() {
        if (mainFolder == null) {
            return "none";
        }
        currentFileArray = mainFolder.listFiles();
        StringBuilder sb = new StringBuilder();
        for (File file : currentFileArray) {
            sb.append(file.getName() + '\t' + file.length()).append(System.lineSeparator());
        }
        sb.append(fileCompare());
        if (flag) {
            return sb.toString();
        }
        return "wait chanchges";
    }

    private String fileCompare() {
        StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currentFileArray.length; i++) {
               int w =  Arrays.binarySearch(previousFileArray, 0,  previousFileArray.length, currentFileArray[i]);
              //  System.out.println(" w " + w);
                if(w < 0) {

                    flag = true;
                    sb.append("new file \"" + currentFileArray[i].getName() +"\"  added to the folder").append(System.lineSeparator());
                }
            }
            for (int i = 0; i < previousFileArray.length; i++){
                int v =  Arrays.binarySearch(currentFileArray, 0,  currentFileArray.length, previousFileArray[i]);
             //   System.out.println(" v " + v);
                if(v < 0) {
                    flag = true;
                    sb.append("file \"" + previousFileArray[i].getName() +"\" removed from the folder").append(System.lineSeparator());
                }
            }

        return sb.toString();
    }

    public boolean infoFlag() {
        System.out.println(getFolderInfo());
        System.out.println(fileCompare());
        return flag;
    }

    public void info() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");
        System.out.println(sdf.format(System.currentTimeMillis()));
        System.out.println(getFolderInfo());
        System.out.println(fileCompare());
        System.out.println();

    }







}
