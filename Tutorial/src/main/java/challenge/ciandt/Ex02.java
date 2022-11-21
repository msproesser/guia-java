package challenge.ciandt;

import java.util.Arrays;
import java.util.List;

public class Ex02 {

    public static List<Integer> exercicio02(List<List<Integer>> vendas) {
        Integer maiorVenda = 0;
        Integer menorVenda = Integer.MAX_VALUE;
        List<Integer> vendasFlatten = vendas.stream()
                .flatMap(List::stream)
                .filter(valor -> valor > 0)
                .toList();
        for (Integer venda : vendasFlatten) {
            if (venda > maiorVenda) maiorVenda = venda;
            if (venda < menorVenda) menorVenda = venda;
        }
        return Arrays.asList(menorVenda, maiorVenda);
    }
}
