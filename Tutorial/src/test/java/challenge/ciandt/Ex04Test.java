package challenge.ciandt;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Ex04Test {

    @Test
    public void test() {
        List<String> expected = List.of("i", "a");

        List<String> resultado = Ex04.calculaOcorrenciaDeQueries("Lorem, ipsum dolor sit amet consectetur adipisicing elit.", List.of("a", "em", "i", "el"), 2);
        Assert.assertEquals(expected, resultado);
    }

    @Test
    public void testMatheus() {
        List<String> expected = List.of("s", "e");

        List<String> resultado = Ex04.calculaOcorrenciaDeQueries("matheus sproesser", List.of("e", "ma", "s", "pr", "ss"), 2);
        Assert.assertEquals(expected, resultado);
    }

    @Test
    public void bigTest() {
        List<String> expected = List.of("i", "a");

        List<String> resultado = Ex04.calculaOcorrenciaDeQueries("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                List.of("a", "em", "i", "el"), 2);
        Assert.assertEquals(expected, resultado);
    }
}
