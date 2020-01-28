package ua.homestack;



public class Stack {
    private Object[] stackArray = new Object[10];
    private int n = 0;
    private BlackList blackList;

    public Stack() {
    }

    public Stack(BlackList blackList) {
        this.blackList = blackList;
    }

    public BlackList getBlackList() {
        return blackList;
    }

    public void setBlackList(BlackList blackList) {
        this.blackList = blackList;
    }
    private  void resizeUp() {
        Object[] temp = new Object[(this.stackArray.length *7) / 4];
        System.arraycopy(stackArray, 0, temp, 0, stackArray.length);
        this.stackArray = temp;
    }
    public boolean addElement(Object obj) {
        if(obj == null) {
            return false;
        }
        if(blackList.checkObject(obj)) {
            System.out.println("class is in BlackList");
            return false;
        }
        if(n==stackArray.length) {
            this.resizeUp();
        }
        stackArray[n++] = obj;
        return true;
    }

     // Получает последний элемент стека и удаляет его
    public Object getLastElementAndDel() {
        if(n==0) {
            return null;
        }
        Object temp = stackArray[--n];
        stackArray[n] = null;
        return temp;
    }
    // * Получает последний элемент стека
    public Object getLastElement(){
        if(n==0){
            return null;
        }
        return stackArray[n-1];
    }
    // Text representation of the stack
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (stackArray[i] == null) {
                continue;
            }
            sb.append(stackArray[i].getClass() + "   ").append(stackArray[i]);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
