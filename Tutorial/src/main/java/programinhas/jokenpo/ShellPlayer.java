package programinhas.jokenpo;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

/**
 * <h1>ShellPlayer</h1>
 * <p>Classe responsável em possibilitar entrada de dados pelo usuario.</p>
 * <p>Nessa modalidade ShellPlayer deverá <b>substituir uma IAPlayer na classe Inicio no método main.</b></p>
 * @author Matheus Sproesser
 * @version 1.1
 * @since 25/12/2022
 * @contributed Lígia Alves
 */

public class ShellPlayer implements Player {

    private final String name;
    private final Scanner reader;
    public ShellPlayer(String name) {
        this.name = name;
        this.reader = new Scanner(System.in);
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * <p>Método responsável em obter a escolha do jogador para confrontar com o seu oponente.</p>
     * <p>Esse metodo possui um laço de repetição <b>for</b> para verificar se a escolha é menor ou igual ao tamanho do array das constantes da classe Options.</p>
     * @return a jogada escolhida conforme classe Options.
     */
    @Override
    public Options getGesture() {
        var options = Options.values();
        System.out.println("Pick an option");
        for(int i = 0; i < options.length; i++) {
            System.out.println(i + ": " + options[i].name());
        }
        var selected = reader.nextInt();
        if (selected >= options.length) return null;
        return options[selected];
    }
}