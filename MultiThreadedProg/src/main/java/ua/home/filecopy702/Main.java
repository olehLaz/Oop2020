package ua.home.filecopy702;

public class Main {
    public static void main(String[] args) {
        String in = "C:\\111\\PUNK.txt";
        String out = "C:\\222";
        FileControler filecontroler = new FileControler(in, out);
        filecontroler.copy();
    }
}
