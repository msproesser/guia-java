package programinhas.jokenpo;

/**
 * <h1>IAPlayer</h1>
 * <p>Classe responsável em criar o jogador <b>IAPlayer</b> através da implementação da interface Player.</p>
 * <p>Esse jogador possui as jogadas criadas de forma aleatória.</p>
 * @author Matheus Sproesser
 * @version 1.0
 * @since 25/12/2022
 */
public class IAPlayer implements Player {

    private final String name;

    public IAPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Método que irá gerar a escolha do jogador aleatóriamente usando a classe <b>Options</b>.
     * @return
     */
    @Override
    public Options getGesture() {
        int index = (int) Math.floor(Math.random() * Options.values().length);
        var opt = Options.values()[index];
        System.out.println("IA Player " + name + " selected option: "+opt.name());
        return opt;
    }
}
