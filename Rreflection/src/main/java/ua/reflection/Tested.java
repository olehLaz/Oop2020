package ua.reflection;

public class Tested {
    @Test(a=5, b=12)
    public static void test(int a, int b){
        System.out.println(a + b);
    }
}
