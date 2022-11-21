package challenge.ciandt;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Ex01Test {

    @Test
    public void testBase() {
        Integer parada = Ex01.ultimaParada(2, 8, Arrays.asList(2, 15, 22, 11));
        Assert.assertEquals((Integer) 15, parada);
    }

    @Test
    public void testSemPostoViavel() {
        Integer expected = -1;
        Integer parada = Ex01.ultimaParada(2, 8, Arrays.asList(20, 30, 40, 33, 22));
        Assert.assertEquals(expected, parada);
    }
}
