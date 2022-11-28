package challenge.ciandt;

import java.util.*;

public class Ex04Streams {

    public static List<String> calculaOcorrenciaDeQueries(String texto, List<String> queries, Integer k) {
        // uso stream para passar por cada elemento da lista de queries
        return queries.stream()
                // map: para cada query em queries, converto a query num objeto key/value "simpleEntry"
                // onde a chave é a query e o valor é o numero de incidencias (usando o metodo contarIncidencias)
                .map(query -> new AbstractMap.SimpleEntry<>(query, contarIncidencias(texto, query, 0)))
                // sorted, uso para ordenar com base no valor das entries usando getValue()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                // agora que está ordenado eu retiro apenas os k primeiros (maiores incidencias)
                .limit(k)
                // map: usando map converto uma entry para sua chave, descartando o valor
                .map(AbstractMap.SimpleEntry::getKey)
                // converto para lista no final e esse é o retorno
                .toList();
    }

    // criei uma função recursiva que busca por incidencias de uma query sobre o texto levando em consideração o offset
    private static int contarIncidencias(String texto, String query, Integer offset) {
        int index = texto.indexOf(query, offset);
        if (index >= 0) return 1 + contarIncidencias(texto, query, index + 1);
        return 0;
    }
}
