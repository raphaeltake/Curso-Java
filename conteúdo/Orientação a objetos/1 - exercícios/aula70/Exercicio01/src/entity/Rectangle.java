package entity;

public class Rectangle {
    public double width;
    public double height;

    public double Area(){
        return width * height;
    }

    public double Perimeter(){
        return (width + height) * 2;
    }

    public double Diagonal(){
        return Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

    public String toString(){
        return String.format("AREA = %.2f%n" +
                "PERIMETER = %.2f%n" +
                "DIAGONAL = %.2f", Area(), Perimeter(), Diagonal());
    }
}
