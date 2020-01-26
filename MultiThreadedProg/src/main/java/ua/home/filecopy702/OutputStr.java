package ua.home.filecopy702;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class OutputStr implements Runnable {
    private Path path;
    private byte[] bytes;
    private String workFile;

    public OutputStr(byte[] bytes, Path path, String copyDirectory) {
        this.path = path;
        this.bytes = bytes;
        this.workFile = copyDirectory + "\\" + this.path.getFileName();
        ;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getWorkFile() {
        return workFile;
    }

    public static void bufferCopyToFile(byte[] bytes, String workFile) throws IOException {
        File out = new File(workFile);
        try(FileOutputStream fos = new FileOutputStream(out);
            BufferedOutputStream bos = new BufferedOutputStream(fos, 1024)) {
            System.out.print("##");
            bos.write(bytes, 0, bytes.length);
            bos.close();
            System.out.println(" ] end");
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public void run() {
        //	System.out.println(" out " + Thread.currentThread().getName());
        try {
            bufferCopyToFile(bytes, workFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
