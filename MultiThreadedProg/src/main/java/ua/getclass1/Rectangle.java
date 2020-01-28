package ua.getclass1;

import java.util.HashMap;
import java.util.Objects;

public class Rectangle implements Cloneable {
    private double length;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(" Rectange dectroed!! ");
        super.finalize();
    }



    @Override
    public boolean equals(Object obj) {
    //    return super.equals(obj);
        if(this == obj) return true; //1
        else if(obj == null) return false; //5
        else if (this.getClass() != obj.getClass()) return false; //2
        Rectangle other = (Rectangle) obj;
        if(Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
            return false; //3
        if(Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false; //3
        return true;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result =1;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }
}
