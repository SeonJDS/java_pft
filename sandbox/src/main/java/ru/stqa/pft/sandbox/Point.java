package ru.stqa.pft.sandbox;

import static ru.stqa.pft.sandbox.PointsHomeWork.square;

public class Point {

    public double a;
    public double b;

    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double distance(Point p2) { //метод рассчитывающий дистанцию между двумя точками
        return Math.sqrt(squareX(p2.a, this.a) + squareX(p2.b, this.b));
    }

    public static double squareX(double a, double b) { //функция расччитывающая квадрат разницы двух чисел
        return (a * a) - 2 * a * b + (b * b);
    }

}
