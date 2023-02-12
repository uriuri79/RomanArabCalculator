package org.example;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void calcTestAddTwoArabianNumbers() {
        String actual = Main.calc("1+2");
        Assert.assertEquals("1 + 2 = 3", actual);
    }

    @Test
    public void calcTestAddTwoRomanNumbers() {
        String actual = Main.calc("v+x");
        Assert.assertEquals("V + X = XV", actual);
    }

    @Test
    public void calcTestMinusTwoArabianNumbers() {
        String actual = Main.calc("8-6");
        Assert.assertEquals("8 - 6 = 2", actual);
    }

    @Test
    public void calcTestMinusTwoRomanNumbers() {
        String actual = Main.calc("v-ii");
        Assert.assertEquals("V - II = III", actual);
    }

    @Test(expected = RuntimeException.class)
    public void calcTestMinusTwoRomanNumbersError() {
        Main.calc("ii-iii");
    }

    @Test(expected = RuntimeException.class)
    public void calcTestDifferentTypesNumbersError() {
        Main.calc("i+2");
    }

    @Test(expected = RuntimeException.class)
    public void calcTestNoMathExpressionError() {
        Main.calc("2");
    }

    @Test(expected = RuntimeException.class)
    public void calcTestTwoOperationError() {
        Main.calc("1+2+3");
    }
}