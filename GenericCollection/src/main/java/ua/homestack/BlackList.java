package ua.homestack;

public class BlackList {
    private Class<?>[] classArray = new Class<?>[5];
    private int n = 0;

    public BlackList() {
    }
    public void addClassToList(Class<?> classOne) {
        if(isClassPresent(classOne)) {
            return;
        }
        if(n==this.classArray.length) {
            Class<?>[] temp = new Class<?>[(classArray.length*7)/4 +1];
            System.arraycopy(classArray, 0, temp, 0, classArray.length);
            classArray = temp;
        }
        classArray[n++] = classOne;
        System.out.println(" n= " + n + "  " + " classArray.length= " + classArray.length);
     //   System.out.println(classArray.toString());
    }

    private boolean isClassPresent(Class<?> classOne) {
        for(Class<?> classes : classArray) {
            if (classes != null && classes.equals(classOne)){
                return true;
            }
        }
        return false;
    }
    public boolean checkObject(Object obj) {
        return isClassPresent(obj.getClass());
    }





}
