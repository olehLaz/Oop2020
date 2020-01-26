package ua.multithreadedprog.notify1;

public class Document {
    private volatile byte[] data;
   //public static boolean flag = false;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
    public boolean isReady() {
        return data != null;
    }
}
