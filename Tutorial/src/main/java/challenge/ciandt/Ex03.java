package challenge.ciandt;

import java.util.List;

public class Ex03 {

    public static Integer decripto(List<String> senhas) {
        StringBuilder somaSenha = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int contador = 0;
            for (String senha : senhas) {
                if (senha.charAt(i) == '1') contador ++;
            }
            somaSenha.append((contador *2) > senhas.size() ? '1' : '0');
        }
        return Integer.parseInt(somaSenha.toString(), 2);
    }
}
