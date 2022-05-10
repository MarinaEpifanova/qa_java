package com.example;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import java.util.List;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoRule;


@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean expected;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Feline feline;

    public LionTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(this.sex, feline);
        given(feline.getKittens()).willReturn(1);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(this.sex, feline);
        Assert.assertEquals(this.expected, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void doesHaveManeException() throws Exception {
        Lion lion = new Lion("Неведома зверюшка", feline);
        Assert.assertEquals(this.expected, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Lion lion = new Lion(this.sex, feline);
        given(feline.eatMeat()).willReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}