package com.example;
import org.junit.Test;
import org.junit.Assert;
import java.util.List;

public class FelineTest {

    @Test
    public void eatMeat() throws Exception {
        Feline feline = new Feline();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamily() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getOneKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens());
    }

    @Test
    public void getManyKittens() {
        Feline feline = new Feline();
        Assert.assertEquals(5, feline.getKittens(5));
    }
}