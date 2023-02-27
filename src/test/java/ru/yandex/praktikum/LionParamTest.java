package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class LionParamTest {
    @Spy
    Feline feline = new Feline();
    private final String sex;
    private final boolean hasMane;

    public LionParamTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters()
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"qwerty", true},
        };
    }

    @Test
    public void hasManeTest() {
        try {
            Lion lion = new Lion(sex,feline);
            boolean actual = lion.doesHaveMane();
            Assert.assertEquals(hasMane, actual);
        } catch (Exception e) {
            Assert.assertEquals(hasMane, e.getMessage().equals("Используйте допустимые значения пола животного - самей или самка"));
        }
    }
}
