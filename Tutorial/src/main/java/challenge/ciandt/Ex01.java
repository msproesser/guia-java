package challenge.ciandt;

import java.util.Collections;
import java.util.List;

public class Ex01 {
    public static Integer ultimaParada01(Integer combustivel, Integer consumo, List<Integer> postosGasolina) {
        Integer rendimento = combustivel * consumo; // calcula o rendimento maximo do veiculo
        List<Integer> postosViaveis = postosGasolina
                .stream()
                .filter(posto -> posto < rendimento) // remove todos postos impossiveis
                .toList();                           // de chegar com o rendimento atual
        if (postosViaveis.size() == 0) return -1;  // se não restar posto viavel, então retorna -1

        return Collections.max(postosViaveis); // entre os postos viaveis retornar o mais distante
    }

    public static Integer ultimaParada(Integer combustivel, Integer consumo, List<Integer> postosGasolina) {
        Integer rendimento = combustivel * consumo; // calcula o rendimento maximo do veiculo
        Integer melhorPosto = -1;
        for (Integer posto: postosGasolina) {
            if (posto < rendimento && posto > melhorPosto) melhorPosto = posto;
        }
        return melhorPosto;
    }
}
