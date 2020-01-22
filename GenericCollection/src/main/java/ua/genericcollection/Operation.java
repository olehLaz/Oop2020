package ua.genericcollection;



public class Operation <T extends Number, V extends Number> {
    private T obj;
    private V obj1;

    public Operation(T obj, V obj1) {
        this.obj = obj;
        this.obj1 = obj1;
    }
    public double sum() {
        return  obj.doubleValue() + obj1.doubleValue();
    }

    @Override
    public String toString() {
        return "Operation{" +
                "obj=" + obj +
                ", obj1=" + obj1 +
                '}';
    }
}
