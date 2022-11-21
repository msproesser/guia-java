package challenge.ciandt;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {

    public static List<Integer> sorteio(List<Boolean> assinantes, List<Integer> minutos) {
        List<Integer> creditos = new ArrayList<>();
        double total = 0;
        for (int i = 0; i < assinantes.size(); i++) {
            int horas = (int) Math.ceil(minutos.get(i)/60d);
            int multiplicador = assinantes.get(i) ? 2 : 1;
            int credito = horas * multiplicador;
            total += credito;
            creditos.add(credito);
        }
        List<Integer> chances = new ArrayList<>();
        for (Integer credito : creditos) {
            int chance = (int) Math.ceil(100*(credito/total));
            chances.add(chance);
        }
        return chances;
    }
}
