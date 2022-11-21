package challenge.ciandt;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class Ex02Test {

    @Test
    public void test() {
        List<Integer> resultado = Ex02.exercicio02(asList(
                asList(100, 500),
                asList(0, 400),
                asList(0, 200),
                asList(600),
                asList()
        ));

        Integer expectedMin = 100;
        Integer expectedMax = 600;
        Assert.assertEquals(expectedMin, resultado.get(0));
        Assert.assertEquals(expectedMax, resultado.get(1));
    }
}
