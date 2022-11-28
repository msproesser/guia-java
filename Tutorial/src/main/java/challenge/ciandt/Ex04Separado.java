package challenge.ciandt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex04Separado {

    public static List<String> calculaOcorrenciaDeQueries(String texto, List<String> queries, Integer k) {
        List<Integer> contador = queries.stream()
                .map(query -> contarIncidencias(texto, query, 0))
                .collect(Collectors.toList());

        List<String> resultados = new ArrayList<>();
        for (int posicao = 0; posicao < k; posicao++) {
            Integer indexFavorito = buscarMaiorQuery(contador);
            resultados.add(queries.get(indexFavorito));
            contador.set(indexFavorito, -1);
        }
        return resultados;
    }

    private static int contarIncidencias(String texto, String query, Integer offset) {
        int index = texto.indexOf(query, offset);
        if (index >= 0) return 1 + contarIncidencias(texto, query, index + 1);
        return 0;
    }

    private static Integer buscarMaiorQuery(List<Integer> contador) {
        Integer scoreFavorito = 0;
        Integer indexFavorito = 0;
        for (int i = 0; i < contador.size(); i++) {
            if (scoreFavorito < contador.get(i)) {
                scoreFavorito = contador.get(i);
                indexFavorito = i;
            }
        }
        return indexFavorito;
    }
}
