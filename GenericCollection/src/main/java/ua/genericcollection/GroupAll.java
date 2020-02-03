package ua.genericcollection;

public class GroupAll<E> {
    //private E[] arr = new E[10]; //ошибка
    //создание объекта обобщённого типа только через приведение Object
    private E[] arr = (E[]) new Object[10];
    private int i = 0;

    public void  add(E st) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                arr[i] = st;
                this.i++;
                return;
            }
        }
    }

    public int getI() {
        return i;
    }

//обобщённый метод но другого типа T (ограничение Number)
    <T extends Number> double sum(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
    //метод сравнения который может работать с любой группой <?>
    public boolean check(GroupAll<?> a) {
        return (this.getI() == a.getI());
    }
}
