package programinhas.jokenpo;
/**
 * <h1>Player</h1>
 * <p><b>Interface</b> com 2 métodos de implementação obrigatória, nome do jogador e gesto/escolha da jogada.</p>
 * <p>o gesto/escolha do jogador será um valor obtido da classe de constantes <b>Options</b>.</p>
 * <br>
 * @var String name
 * @var gesto/escolha do jogador do tipo Options(array com 5 opçoes de jogadas)
 * @author Matheus Sproesser
 * @version 1.0
 * @since 25/12/2022
 */
public interface Player {

    String getName();
    Options getGesture();
}