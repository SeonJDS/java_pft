package ru.stqa.pft.sandbox;

public class PointsHomeWork {

    public static void  main(String[] args) {

        Point p1 = new Point(1.0, 3.0);
        Point p2 = new Point(2.0, 5.0);

        System.out.println("Distance between point p1 " + p1.a + ", " + p1.b + " & point p2 " + p2.a + ", " + p2.b  + " = " + distance(p1, p2));//вывод на экран результат действия функции distance описанной вутри класса PointHomework

        System.out.println("Distance between point p1 " + p1.a + ", " + p1.b + " & point p2 " + p2.a + ", " + p2.b  + " = " + p1.distance(p2));//вывод на экран результат действия функции distance описанной вутри класса Point

    }

    public static double distance(Point p1, Point p2) { //функция рассчитывающая дистанцию между двумя точками
        return Math.sqrt(square(p2.a, p1.a) + square(p2.b, p1.b));
    }

    public static double square(double a, double b) { //функция расччитывающая квадрат разницы двух чисел
        return (a * a) - 2 * a * b + (b * b);
    }
}
