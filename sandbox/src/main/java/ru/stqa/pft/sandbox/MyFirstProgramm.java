package ru.stqa.pft.sandbox;

public class MyFirstProgramm {

    public static void main(String[] args) {

        hello("Vasya!");

        double l = 5;
        System.out.println("Area of a square with a side that euqals: " + l + " = " + area(l));

        double a = 4;
        double b = 6;
        System.out.println("Area of a rectangle with sides that are equl: " + a + " & " + b + " = " + area(a, b));
    }

    public static void  hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static double  area(double l) {
        return l * l;
    }

    public static double area(double a, double b) {
        return a * b;
    }
}