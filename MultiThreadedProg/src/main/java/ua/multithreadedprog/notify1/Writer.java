package ua.multithreadedprog.notify1;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer extends Thread {
    private final Document doc;
    private final String path;
    private static final Logger logger = LoggerFactory.getLogger(Writer.class);

    public Writer(Document doc, String path) {
        this.doc = doc;
        this.path = path;
    }

    @Override
    public void run() {
      //  System.out.println("Writing document to ... " + path);
        synchronized (doc) {
            while (!doc.isReady()) {
                try{
                    doc.wait();
                } catch (InterruptedException e) {
                    logger.error("InterruptedException thrown: ", e);
                    return;
                }
            }
        }
        System.out.println("Writing document to ... " + path);

        try(FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(doc.getData());
            System.out.println(" Down:  " + path);


        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException thrown: ", e);
        } catch (IOException e) {
            logger.error("IOException thrown: ", e);
        }
    }
}
