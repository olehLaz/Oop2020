package ua.multithreadedprog.notify1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Downloader extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Downloader.class);
    private final String link;
    private final Document doc;


    public Downloader(String link, Document doc) {
        this.link = link;
        this.doc = doc;
    }

    @Override
    public void run() {
        System.out.println("Downloader  file ... ");
        synchronized (doc) {
            byte[] data = downloadFile();
            if (data == null)
                throw new RuntimeException("Download Failed ");
            doc.setData(data);

            doc.notifyAll();
        }
    }

    private byte[] downloadFile() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            try {
                InputStream stream = connection.getInputStream();
                byte[] buf = new byte[1024];
                int read =0;
                while ((read = stream.read(buf)) != -1) {
                    bos.write(buf, 0, read);

                }
                bos.flush();
                bos.close();
            } finally {
                connection.disconnect();

            }
        } catch (MalformedURLException e) {
            logger.error("MalformedURLException thrown: ", e);
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("Exception thrown: ", e);
            return null;
        }
       // Document.flag=true;
        return bos.toByteArray();
    }
}
