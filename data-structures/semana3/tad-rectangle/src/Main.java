//import java.awt.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Point a = new Point(1,1);
//        Point b = new Point(2,2);
//        Point c = new Point(3,4);
//        Point d = new Point(8,2);
//
//        Rectangle amarelo  = new Rectangle(a, c);
//        Rectangle laranja  = new Rectangle(2, 3, 9, 6);
//        Rectangle verde    = new Rectangle(3, 4, 4, 5);
//        Rectangle azul     = new Rectangle(5, 1, 6, 5);
//        Rectangle vermelho = new Rectangle(7, 3, 9, 5);
//
//        System.out.println("Perimetro do retangulo amarelo = " + amarelo.perimeter()); // 10
//        System.out.println("Perimetro do retangulo laranja = " + laranja.perimeter()); // 20
//
//        System.out.println("Area do retangulo amarelo = " + amarelo.area()); // 6
//        System.out.println("Area do retangulo laranja = " + laranja.area()); // 21
//
//        System.out.println("Ponto B dentro rectangulo amarelo? " + amarelo.pointInside(b)); // true
//        System.out.println("Ponto D dentro rectangulo amarelo? " + amarelo.pointInside(d)); // false
//
//        System.out.println("Retangulo verde dentro do laranja? " + laranja.rectangleInside(verde));       // true
//        System.out.println("Retangulo azul dentro do laranja? " + laranja.rectangleInside(azul));         // false
//        System.out.println("Retangulo vermelho dentro do laranja? " + laranja.rectangleInside(vermelho));
//    }
//}
//class Point {
//    int x, y;
//
//    Point() {
//        x = y = 0;
//    }
//
//    Point(int x0, int y0) {
//        x = x0;
//        y = y0;
//    }
//
//    public String toString() {
//        return "(" + x + "," + y + ")";
//    }
//}

import java.awt.*;

class Rectangle{
    public Point point1;
    public Point point2;

    public Rectangle(int x1, int x2, int y1, int y2) {
        this.point1 = new Point(x1,x2);
        this.point2 = new Point(y1,y2);

    }
    public Rectangle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public int area(){
        return Math.abs(point2.x - point1.x) * Math.abs(point2.y - point1.y);
    }
    public int perimeter(){
        return (Math.abs(point2.x - point1.x) * 2) + (Math.abs(point2.y - point1.y) * 2);
    }
    public boolean pointInside(Point p){
        return (p.x >= point1.x && p.x <= point2.x) && (p.y >= point1.y && p.y <= point2.y);
    }

    public boolean rectangleInside(Rectangle r){
        return ((r.point1.x >= this.point1.x && r.point1.x <= this.point2.x)
                && (r.point1.y >= this.point1.y && r.point1.y <= this.point2.y))
                && ((r.point2.x >= this.point1.x && r.point2.x <= this.point2.x)
                && (r.point2.y >= this.point1.y && r.point2.y <= this.point2.y));
    }
}