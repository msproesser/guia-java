package challenge.ciandt;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Ex03Test {

    @Test
    public void test() {
        Integer expected = 7;
        Integer resultado = Ex03.decripto(List.of(
                "0000000101",
                "0000000111",
                "0000000110"
        ));
        Assert.assertEquals(expected, resultado);
    }

    @Test
    public void test2() {
        int div = 2;
        System.out.println(3d/div);
    }
}
