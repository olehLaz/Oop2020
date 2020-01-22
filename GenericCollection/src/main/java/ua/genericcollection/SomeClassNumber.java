package ua.genericcollection;

public class SomeClassNumber <T extends Number > {
    private T obj;

    public SomeClassNumber(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "SomeClassNumber{" +
                "obj=" + obj +
                '}';
    }
}
