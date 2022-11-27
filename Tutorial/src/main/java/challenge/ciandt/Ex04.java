package challenge.ciandt;

import java.util.ArrayList;
import java.util.List;

public class Ex04 {

    public static List<String> calculaOcorrenciaDeQueries(String texto, List<String> queries, Integer k) {
        // vou usar essa lista para contabilizar a ocorrencia de cada item em queries
        List<Integer> contador = new ArrayList<>(queries.stream().map(x -> 0).toList());
        //converto o texto para uma lista de char, assim consigo navegar letra por letra
        char[] chars = texto.toCharArray();
        // para cada letra do texto
        for (int i = 0; i < chars.length; i++) {
            // para cada item na lista de queries
            // (aqui uso um for com indice pq preciso saber a posição para incrementar meu contador)
            for (int queryIndex = 0; queryIndex < queries.size(); queryIndex++) {
                //para cada item da query
                String query = queries.get(queryIndex);
                boolean match = true;
                //percorro os caracteres daquela query usando indice por conta de query com mais de um character
                for (int queryChar = 0; queryChar < query.length(); queryChar++) {
                    // aqui testo se o char atual é igual ao char na posição atual do texto [i + queryChar]
                    // o resultado eu combino com o "match" usando AND, se houver algum caracter diferente o resultado sera false
                    // se todos caracteres forem iguais, será true
                    match = match && chars[i + queryChar] == query.charAt(queryChar);
                }
                //apos percorrer todos caracteres de uma query eu vejo se deu match
                if (match) {
                    //se fim eu incremento o contador no index referente aquela query
                    Integer count = contador.get(queryIndex);
                    // uso o set para retornar o valor para a posição espcifica
                    contador.set(queryIndex, count + 1);
                }
            }
        }
        // aqui terei percorrido todos os caracteres e testado cada um com todas as queries disponiveis e o contador estará preenchido
        List<String> resultados = new ArrayList<>();
        // repetir k vezes, passado pelo parametro k
        for (int posicao = 0; posicao < k; posicao++) {
            // como estamos trabalhando com lista em vez de map, precisamos saber o index "vencedor" e o valor do "vencedor"
            Integer scoreFavorito = 0;
            Integer indexFavorito = 0;
            // para cada item do contador
            for (int i = 0; i < contador.size(); i++) {
                // compara se o valor é maior que valor atual informado, se for maior ele passa a ser o favorito
                if (scoreFavorito < contador.get(i)) {
                    scoreFavorito = contador.get(i);
                    indexFavorito = i;
                }
            }
            // apos determinar o favorito (ou vencedor) adicionamos o valor da query em resultados baseado no indexFavorito
            resultados.add(queries.get(indexFavorito));
            // aqui zeramos o valor de quem foi o favorito para que seja desconsiderado nos proximos turnos
            contador.set(indexFavorito, -1);
        }

        return resultados;
    }

}
