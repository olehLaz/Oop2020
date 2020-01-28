package ua.object1;

public class MainRectangle {
    public static void main(String[] args) {
        Rectangle rectOne = new Rectangle(3,4);
        Rectangle rectTwo = new Rectangle(3,4);

        System.out.println(rectOne);
        System.out.println(rectOne.hashCode());
        System.out.println(rectTwo.hashCode());


        /*
        for (int i = 0; i <  10; i++) {
            new Rectangle(2,3);
        }

        System.gc();
        System.out.println(" main method stop ");
        */
        //сравнивает ссылки на объект
        if(rectOne == rectTwo){
            System.out.println(" rectOne == rectTwo");
        } else {
            System.out.println(" rectOne != rectTwo");
        }

        //сравнивает  объекты по свойствам
        if(rectOne.equals(rectTwo)){
            System.out.println(" rectOne equals rectTwo");
        } else {
            System.out.println(" rectOne not equals rectTwo");
        }

        Rectangle rectThree = null;
        try {
            rectThree = rectTwo.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(rectThree.hashCode());
        if(rectThree == rectTwo){
            System.out.println(" rectThree == rectTwo");
        } else {
            System.out.println(" rectThree != rectTwo");
        }
        if(rectThree.equals(rectTwo)){
            System.out.println(" rectThree equals rectTwo");
        } else {
            System.out.println(" rectThree not equals rectTwo");
        }



    }
}
