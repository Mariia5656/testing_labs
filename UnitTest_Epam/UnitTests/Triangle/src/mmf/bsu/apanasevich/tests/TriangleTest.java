package mmf.bsu.apanasevich.tests;

import mmf.bsu.apanasevich.triangle.Triangle;
import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void isFalseWhenSidesAreNegative() {
        Assert.assertFalse(Triangle.buildTriangle(-2, 3, 4));
        Assert.assertFalse(Triangle.buildTriangle(2, -3, 4));
        Assert.assertFalse(Triangle.buildTriangle(2, 3, -4));
    }

    @Test
    public void isFalseWhenSidesAreZero() {
        Assert.assertFalse(Triangle.buildTriangle(0, 3, 4));
        Assert.assertFalse(Triangle.buildTriangle(2, 0, 4));
        Assert.assertFalse(Triangle.buildTriangle(2, 3, 0));
    }

    @Test
    public void isTrueWhenSidesAreEqual(){
        Assert.assertTrue(Triangle.buildTriangle(6,6,6));
    }

    @Test
    public void isFalseWhenSumOfTwoIsEqualThird(){
        Assert.assertFalse(Triangle.buildTriangle(2, 3, 6));
    }

    @Test
    public void isTrueWhenSumOfTwoSmallIsHigherThenThirdSide(){
        Assert.assertFalse(Triangle.buildTriangle(4, 5, 8));
    }

    @Test
    public void isTrueWhenSidesAreRight() {
        Assert.assertTrue(Triangle.buildTriangle(5, 6, 8));
        Assert.assertEquals("Simple triangle", Triangle.typeOfTriangle(5, 6, 8));
    }

    @Test
    public void isFalseWhenSidesAreNotRight() {
        Assert.assertFalse(Triangle.buildTriangle(1, 2, 13));
        Assert.assertFalse(Triangle.buildTriangle(11, 2, 3));
        Assert.assertFalse(Triangle.buildTriangle(1, 12, 3));
    }

    @Test
    public void isNotEquilateralWhenSidesAreNotEqual(){
        Assert.assertEquals("Not equilateral triangle", Triangle.typeOfTriangle(3, 4, 6));
    }

    @Test
    public void isEquilateralWhenSidesAreEqualEachOther(){
        Assert.assertEquals("equilateral triangle", Triangle.typeOfTriangle(5, 5, 5));
    }

    @Test
    public void isIsoscelesWhenTwoSidesAreEqual(){
        Assert.assertEquals("Isosceles triangle", Triangle.typeOfTriangle(3, 3, 4));
    }


