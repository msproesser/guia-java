package challenge.ciandt;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Ex05Test {

    @Test
    public void test() {
        List<Integer> expected = List.of(25, 25, 50);
        List<Integer> resultado = Ex05.sorteio(List.of(true, false, true), List.of(60, 120, 120));
        Assert.assertEquals(expected, resultado);
    }
}
