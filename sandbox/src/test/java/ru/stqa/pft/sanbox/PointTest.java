package ru.stqa.pft.sanbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTest {

    @Test
    public void verifyDistanceEqual() { //проверка, что расстояние между точками больше 0.
        Point p1 = new Point(4, 2);
        Point p2 = new Point(5, 3);
        Assert.assertTrue(p1.distance(p2) > 0);
    }

    @Test
    public void verifyNumberCorrect() { //проверка, что число возвращаемое методом distance равно числу, которое было найденно на сайте, где находится расстояние между точками.
        Point p1 = new Point(4, 2);
        Point p2 = new Point(5, 3);
        Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
    }
}
