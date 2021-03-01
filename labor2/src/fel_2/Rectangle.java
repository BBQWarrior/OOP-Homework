package fel_2;

public class Rectangle {
    private double length = 0;
    private double width = 0;

    public Rectangle(double length, double width) {
        if (length >= 0 && width >= 0) {
            this.length = length;
            this.width = width;
        }
    }

    public double area(){
        return length * width;
    }

    public double perimeter(){
        return 2 * (length + width);
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String toString(){
        return length + " x " + width;
    }
}
