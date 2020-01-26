package ua.multithreadedprog.notify1;



public class Sample7 {
    static final String URL = "https://drive.google.com/uc?authuser=0&id=1eNRe5EBc9RAnib1U3LIInueNFDu4vsdH&export=download";

    public static void main(String[] args) {
        Document doc = new Document();

        Writer[] writers = {
                new Writer(doc, "file1.pdf"),
                new Writer(doc, "file2.pdf"),
                new Writer(doc, "file3.pdf")
        };
        for (Writer writer : writers) {
            writer.start();
        }
        Downloader downloader = new Downloader(URL, doc);
        downloader.start();
    }
}
