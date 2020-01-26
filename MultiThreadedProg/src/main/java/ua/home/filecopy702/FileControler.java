package ua.home.filecopy702;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;

public class FileControler {
    private ExecutorService service;
    private String filein;
    private Path path;
    private String copyDirectory;

    public FileControler(String filein, String copyDirectory) {
        this.filein = filein;
        this.copyDirectory = copyDirectory;
        path = Paths.get(filein);
        service = Executors.newScheduledThreadPool(2);
    }

    public void copy() {
        try {
            byte[] bytenew = null;
            if (Files.exists(Paths.get(copyDirectory + "\\" + path.getFileName()))) {
                Files.delete(Paths.get(copyDirectory + "\\" + path.getFileName()));
            }
            InputStr inputStr = new InputStr(path, filein);
            Future<byte[]> future = service.submit(inputStr);
            byte[] bytes;
            try{
                bytes = future.get();
                if(bytes != null){
                    bytenew = new byte[bytes.length];
                    System.arraycopy(bytes, 0, bytenew, 0, bytes.length);
                }
                System.out.println("Buffer ready");
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
            try {
                service.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (future.isDone())
                service.submit(new OutputStr(bytenew, path, copyDirectory));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();

        }

    }
}
